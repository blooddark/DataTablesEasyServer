package com.example.datatablesserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.example.datatablesserver.mapper"})
public class DatatablesServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatatablesServerApplication.class, args);
    }

}
