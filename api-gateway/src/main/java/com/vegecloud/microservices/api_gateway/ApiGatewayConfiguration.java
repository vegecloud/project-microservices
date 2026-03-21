package com.vegecloud.microservices.api_gateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(p -> p
                        .path("/currency-exchange/**")
                        .filters(f -> f.addRequestHeader("CustomHeader", "CustomValue"))
                        .uri("lb://currency-exchange"))
                .route(p -> p
                        .path("/currency-conversion/**")
                        .filters(f -> f.addRequestParameter("CustomParam", "CustomValue"))
                        .uri("lb://currency-conversion"))
                .route(p -> p
                        .path("/currency-conversion-feign/**")
                        .filters(f -> f.addRequestParameter("CustomParam", "CustomValue"))
                        .uri("lb://currency-conversion"))
                .build();
    }

}

// we can also rewrite uri paths for each path
