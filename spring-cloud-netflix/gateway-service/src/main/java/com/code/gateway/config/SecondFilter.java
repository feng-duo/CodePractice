//package com.code.gateway.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @author FengDuo
// * @date 2023/3/1 15:43
// */
//@Component
//@Slf4j
//public class SecondFilter implements GlobalFilter, Ordered {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        log.info("SecondFilter start.");
//        return chain.filter(exchange).then(Mono.fromRunnable(() -> log.info("SecondFilter end.")));
//    }
//
//    @Override
//    public int getOrder() {
//        return 1;
//    }
//}
