package com.vegecloud.microservices.currency_conversion_service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration(proxyBeanMethods = false)
public class RestClientConfiguration {
    @Bean
    RestClient restClient() {
        return RestClient.builder().build();
    }
}
