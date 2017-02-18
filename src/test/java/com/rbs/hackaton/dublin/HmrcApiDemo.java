package com.rbs.hackaton.dublin;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HmrcApiDemo {

    private static final Logger LOG = LoggerFactory.getLogger(HmrcApiDemo.class.getSimpleName());
    public static final String API_ROOT_URL = "https://api.service.hmrc.gov.uk";
    private final HttpClient client;


    public HmrcApiDemo() {
        client = HttpClientBuilder.create().build();
    }

    public static void main(String[] args) throws Exception {
        HmrcApiDemo api = new HmrcApiDemo();
        api.helloWorld();
        api.helloApplication();
    }

    public void helloWorld() throws Exception{
        HttpGet request = new HttpGet(API_ROOT_URL +"/hello/world");
        request.addHeader("Accept", "application/vnd.hmrc.1.0+json");

        // execute the request
        HttpResponse response = client.execute(request);

        // extract the HTTP status code and response body
        int statusCode = response.getStatusLine().getStatusCode();
        String responseBody = EntityUtils.toString(response.getEntity());
        LOG.info("Hello world, status: {}, response: {}",statusCode, responseBody);

    }


    public void helloApplication() throws IOException {
        // replace with your application's server_token
        String serverToken = "4182850d5f016df6999d19864c253a";

// construct the GET request for our Hello Application endpoint
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://api.service.hmrc.gov.uk/hello/application");
        request.addHeader("Accept", "application/vnd.hmrc.1.0+json");
        request.addHeader("Authorization", "Bearer "+serverToken);

// execute the request
        HttpResponse response = client.execute(request);

// extract the HTTP status code and response body
        int statusCode = response.getStatusLine().getStatusCode();
        String responseBody = EntityUtils.toString(response.getEntity());
        LOG.info("Hello application, status: {}, response: {}",statusCode, responseBody);

    }
}
