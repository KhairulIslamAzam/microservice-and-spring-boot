package com.example.microservice.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gateWayRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
//                .route(p -> p.path("/get")
//                        .filters(f-> f.addResponseHeader("MyHeader","MyUri")
//                                    .addRequestParameter("MyParam","MyValue"))
//                        .uri("http://httpbn.org:80"))

//        http://localhost:8765/currency-exchange/currency-exchange/from/USD/to/INR
//        to covert it http://localhost:8765/currency-exchange/from/USD/to/INR by using custom uri via router

                .route(p-> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange"))
                .route(p -> p.path("/currency-conversion/**")
                .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath(
                                "/currency-conversion-new",
                                "/currency-conversion-feign"))
                        .uri("lb://currency-conversion"))
                .build();
    }
}
