package com.tedu.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tedu.java.dao")
public class Springsecuritydemo03Application {

    public static void main(String[] args) {
        SpringApplication.run(Springsecuritydemo03Application.class, args);
    }

}
