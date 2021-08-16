package com.lintrip.java8;

import org.apache.http.client.config.RequestConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(1000)
                .setConnectTimeout(2000).build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(factory);
        ResponseEntity<String> response = restTemplate.getForEntity("http://www.baidu.com", String.class);
        System.out.println(response.getBody());
    }
}
