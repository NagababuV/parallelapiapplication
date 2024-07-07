package com.wa.parallelapiapplication.controller;

import com.wa.parallelapiapplication.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/callApis")
    public String callApis() throws ExecutionException, InterruptedException {
        CompletableFuture<String> api1Response = apiService.callApi1();
        CompletableFuture<String> api2Response = apiService.callApi2();

        // Wait for both API calls to complete
        CompletableFuture.allOf(api1Response, api2Response).join();

        // Combine the results
        return "API 1 Response: " + api1Response.get() + "\n" + 
               "API 2 Response: " + api2Response.get();
    }
}
