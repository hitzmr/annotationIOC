package com.aia.controller;

import com.aia.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args){
        System.out.println("表现层");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        CustomerService customerService = (CustomerService) applicationContext.getBean("customerServiceImpl");
        customerService.saveCustomer();
    }
}
