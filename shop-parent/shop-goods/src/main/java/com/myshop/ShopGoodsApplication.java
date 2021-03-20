package com.myshop;

 import com.myshop.service.CorsConfig;
 import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 @EnableAutoConfiguration(exclude = {CorsConfig.class})
@SpringBootApplication
public class ShopGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopGoodsApplication.class, args);
    }

}
