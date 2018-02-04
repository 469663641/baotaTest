package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by baota on 2018/2/4.
 */
@RestController
@RequestMapping("/security")
public class SecurityController {


    @RequestMapping(value = "/common")
    public String commonAccess(){
        return "common";
    }


    @RequestMapping(value = "/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminAccess(){
        return "admin";
    }
}
