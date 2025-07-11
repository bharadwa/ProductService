package org.arcserve.productservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfiguration {


    @Bean
    public RestTemplate getRestTemplate () {
        return new RestTemplate();
    }
}
