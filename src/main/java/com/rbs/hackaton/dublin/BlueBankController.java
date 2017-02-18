package com.rbs.hackaton.dublin;

import com.rbs.hackaton.dublin.model.AccountInformation;
import com.rbs.hackaton.dublin.model.Customer;
import com.rbs.hackaton.dublin.service.BlueBankService;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class BlueBankController {

    @Autowired
    private BlueBankService service;


    @RequestMapping(value = "/banks/holder", method = RequestMethod.GET)
    public Customer getCustomer(@CookieValue("jwt") String token) {

        return service.getCustomer(token);
    }

    @RequestMapping(value = "/banks/accountInfo", method = RequestMethod.GET)
    public List<AccountInformation> getAccountInformation(@CookieValue("jwt") String token) {

        return service.getAccountInformation(token);
    }

    @RequestMapping(value = "/banks/bluebank", method = RequestMethod.GET)
    public String auth(HttpServletRequest request, HttpServletResponse response,
                       @RequestParam(value = "id_token", required = false) String id_token) throws OAuthSystemException, IOException, OAuthProblemException {


        String clientId = "0f7ef810-2f9c-424c-942a-48c6ea361d9a";
        String clientSecret = "";
        String scope = "openid";
        String redirectUri = "https://localhost:8080/bankofapis";

        //request auth
        // construct the OAuth 2.0 Authorize request
        OAuthClientRequest oAuthClientRequest = OAuthClientRequest
                .authorizationLocation("https://login.microsoftonline.com/bluebankb2c.onmicrosoft.com/oauth2/v2.0/authorize")
                .setResponseType("id_token")
                .setClientId(clientId)
                .setScope(scope)
                .setRedirectURI(redirectUri)
                .setParameter("p", "B2C_1_BlueBankSUSI")
                .buildQueryMessage();

        response.sendRedirect(oAuthClientRequest.getLocationUri());
        return null;
    }


    @RequestMapping(value = "/banks/setjwt", method = RequestMethod.GET)
    public String calc(HttpServletRequest request, HttpServletResponse response,
                       @RequestParam(value = "id_token", required = true) String id_token) throws OAuthSystemException, IOException, OAuthProblemException {
        Cookie c = new Cookie("jwt",id_token);
        c.setDomain("localhost");
        c.setPath("/");
        response.addCookie(c);
        response.sendRedirect("/statements");
        return null;
    }
}
