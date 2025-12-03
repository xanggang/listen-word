package com.listen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableCaching // 缓存
@SpringBootApplication(scanBasePackages = "com")
@MapperScan("com.listen.mapper")
//@EnableScheduling // 低哦那个事任务
public class ListenApplication {

    public static void main(String[] args) {
        System.out.print("start");
        SpringApplication.run(ListenApplication.class, args);
    }

}
