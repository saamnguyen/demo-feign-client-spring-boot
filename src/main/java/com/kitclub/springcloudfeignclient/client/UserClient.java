package com.kitclub.springcloudfeignclient.client;

import com.kitclub.springcloudfeignclient.dto.UserResponse;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com/", name = "USER-CLIENT")
public interface UserClient {

    @GetMapping("/users")
    public List<UserResponse> getUsers();

    @GetMapping("/users/{id}")
    UserResponse getUserById(@PathVariable("id") int id);
}
