package com.bw;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.bw.mapper")
public class BlockchainexplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlockchainexplorerApplication.class, args);
    }

}
