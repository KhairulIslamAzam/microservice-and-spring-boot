//package com.example.apigateway.Configuration;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RouteConfiguration {
//
//    @Bean
//    public RouteLocator getRoute(RouteLocatorBuilder builder){
//
//        System.out.println("API call");
//
//        return builder.routes()
//                .route(
//                        p->p.path("/get")
//                                .filters(f-> f
//                                            .addRequestHeader("MyHeader", "Token Header")
//                                            .addRequestParameter("MyParam", "TokenParam"))
//                                .uri("http://httpbin.org:80")
//                )
//                .route(
//                        p->p.path("/currency/**")
//                                .uri("lb://currency-exchange")
//                )
//                .route(
//                        p->p.path("/currency-calculator/**")
//                                .uri("lb://currency-calculator")
//                )
//                            // Custome route to controller specific route.
//                .route(
//                        p->p.path("/show/**")
//                                .filters(f-> f.rewritePath(
//                                        "/show/(?<segment>.*)", "/currency/${segment}"
//                                ))
//                                .uri("lb://currency-exchange")
//                )
//                .build();
//    }
//}
