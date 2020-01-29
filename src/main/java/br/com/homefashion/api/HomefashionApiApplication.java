package br.com.homefashion.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class HomefashionApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomefashionApiApplication.class, args);
    }

}
