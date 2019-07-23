package com.xns.springbootfast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(locations={"classpath:beans.xml"})
@SpringBootApplication
public class SpringBootFastApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFastApplication.class, args);
    }

}
