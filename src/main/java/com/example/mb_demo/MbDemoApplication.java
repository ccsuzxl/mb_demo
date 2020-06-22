package com.example.mb_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.example.mb_demo.mapper"})
public class MbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MbDemoApplication.class, args);
    }

}
