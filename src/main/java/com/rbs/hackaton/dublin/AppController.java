package com.rbs.hackaton.dublin;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.oltu.oauth2.client.HttpClient;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAuthzResponse;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@EnableAutoConfiguration
public class AppController {
//
//    @RequestMapping(value = "/request_auth", method = RequestMethod.GET)
//    public void auth(HttpServletRequest request, HttpServletResponse response) throws OAuthSystemException, IOException {
//        // replace with your application's client_id and client_secret
//        String clientId = "PlTGjNzMBmjAVUhos2NPfuI2YFka";
//        String clientSecret = "26b545bb-5869-4af8-9902-b1a02d210b50";
//        String scope = "hello";
//        String redirectUri = "https://localhost:8080/auth";
//
//// construct the OAuth 2.0 Authorize request
//        OAuthClientRequest oAuthClientRequest = OAuthClientRequest
//                .authorizationLocation("https://api.service.hmrc.gov.uk/oauth/authorize")
//                .setResponseType("code")
//                .setClientId(clientId)
//                .setScope(scope)
//                .setRedirectURI(redirectUri)
//                .buildQueryMessage();
//
//// redirect to the given location
//        response.sendRedirect(oAuthClientRequest.getLocationUri());
//    }


    @RequestMapping(value = "/income", method = RequestMethod.GET)
    public String auth(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam(value = "code", required = false) String authCode) throws OAuthSystemException, IOException, OAuthProblemException {


        String clientId = "PlTGjNzMBmjAVUhos2NPfuI2YFka";
        String clientSecret = "26b545bb-5869-4af8-9902-b1a02d210b50";
//        String scope = "hello";
        String scope = "read:individual-income";
        String redirectUri = "https://localhost:8080/income";

        if(StringUtils.isEmpty(authCode)){
            //request auth
            // construct the OAuth 2.0 Authorize request
            OAuthClientRequest oAuthClientRequest = OAuthClientRequest
                    .authorizationLocation("https://api.service.hmrc.gov.uk/oauth/authorize")
                    .setResponseType("code")
                    .setClientId(clientId)
                    .setScope(scope)
                    .setRedirectURI(redirectUri)
                    .buildQueryMessage();

// redirect to the given location
            response.sendRedirect(oAuthClientRequest.getLocationUri());
            return null;
        }
        //get access token
        // extract the authorization code from the request querystring

        OAuthAuthzResponse oAuthAuthzResponse =
                OAuthAuthzResponse.oauthCodeAuthzResponse(request);
        String authorizationCode = oAuthAuthzResponse.getCode();

// create OAuth 2.0 Client using Apache HTTP Client
        OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());


// construct OAuth 2.0 Token request for the authorization code
        OAuthClientRequest oAuthClientRequest = OAuthClientRequest
                .tokenLocation("https://api.service.hmrc.gov.uk/oauth/token")
                .setGrantType(GrantType.AUTHORIZATION_CODE)
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRedirectURI(redirectUri)
                .setCode(authorizationCode)
                .buildBodyMessage();

// request the token via the OAuth 2.0 client
        OAuthJSONAccessTokenResponse oAuthJSONAccessTokenResponse = oAuthClient.accessToken(oAuthClientRequest);

// extract the data from the response
        String accessToken = oAuthJSONAccessTokenResponse.getAccessToken();
        String refreshToken = oAuthJSONAccessTokenResponse.getRefreshToken();
        String grantedScope = oAuthJSONAccessTokenResponse.getScope();
        Long expiresIn = oAuthJSONAccessTokenResponse.getExpiresIn();


        //hello user
        // construct the GET request for our Hello User endpoint
        CloseableHttpClient client = HttpClientBuilder.create().build();
//        HttpGet getRequest = new HttpGet("https://api.service.hmrc.gov.uk/hello/user");
        HttpGet getRequest = new HttpGet("https://api.service.hmrc.gov.uk/individual-income/sa/1111111111/annual-summary/2014-15");
        getRequest.addHeader("Accept", "application/vnd.hmrc.1.0+json");
        getRequest.addHeader("Authorization", "Bearer "+accessToken);

// execute the request
        HttpResponse getResponse = client.execute(getRequest);

// extract the HTTP status code and response body
        int statusCode = getResponse.getStatusLine().getStatusCode();
        String responseBody = EntityUtils.toString(getResponse.getEntity());
        return responseBody;

    }


    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String income(){
        return "result";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloworld(){
        return "hello";
    }
}
