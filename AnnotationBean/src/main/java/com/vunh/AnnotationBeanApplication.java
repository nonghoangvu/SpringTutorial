package com.vunh;

import com.vunh.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AnnotationBeanApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationBeanApplication.class);
        Employee employee = (Employee) context.getBean("abcOrNameMethodConfig");
        System.out.println(employee.getName());
        context.close();
    }

}
