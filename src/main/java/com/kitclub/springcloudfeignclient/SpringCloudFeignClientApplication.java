package com.kitclub.springcloudfeignclient;


import com.kitclub.springcloudfeignclient.client.UserClient;
import com.kitclub.springcloudfeignclient.dto.UserResponse;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EnableFeignClients
public class SpringCloudFeignClientApplication {
    @Autowired
    private UserClient client;

    @GetMapping("/findAllUser")
    public List<UserResponse> getAllUser(){
        return client.getUsers();
    }

    @GetMapping("/findUserById/{id}")
    public UserResponse getUserById(@PathVariable int id){
        return client.getUserById(id);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignClientApplication.class, args);
    }

}
