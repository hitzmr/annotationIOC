package com.aia.controller;

import com.aia.config.SpringConfig;
import com.aia.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client1 {
    public static void main(String[] args){
        System.out.println("表现层");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        CustomerService customerService = (CustomerService) applicationContext.getBean("customerServiceImpl");
        customerService.saveCustomer();
    }
}
