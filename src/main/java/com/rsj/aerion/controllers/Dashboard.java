package com.rsj.aerion.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class Dashboard {

    @GetMapping("/server")
    public ResponseEntity<?> getServerData() {
        return null;
    }

}
