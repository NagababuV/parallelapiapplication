package com.wa.parallelapiapplication.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class ApiService {

    private final RestTemplate restTemplate;

    public ApiService() {
        this.restTemplate = new RestTemplate();
    }

    public CompletableFuture<String> callApi1() {
        return CompletableFuture.supplyAsync(() -> 
            restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", String.class)
        );
    }

    public CompletableFuture<String> callApi2() {
        return CompletableFuture.supplyAsync(() -> 
            restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/2", String.class)
        );
    }
}
