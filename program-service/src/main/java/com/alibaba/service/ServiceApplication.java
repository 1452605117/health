package com.alibaba.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ServiceApplication {
    public static void main(String[] args) throws IOException {
        new ClassPathXmlApplicationContext("classpath:spring-service.xml");
        System.in.read();
    }
}
