package com.alenagordeeva.spring.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.alenagordeeva.spring.rest")
public class MyConfig {


    @Bean //этот бин будет использоваться для осуществения HTTP-request-ов, поэтому в классе Communication должна быть прописана зависимость от него
    public RestTemplate restTemplate() {
    //вспомогательный класс самого Spring для совершения HTTP запросов из Rest-клиента
        return new RestTemplate();
    }
}
