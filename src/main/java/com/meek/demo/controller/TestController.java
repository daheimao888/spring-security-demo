package com.meek.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import java.util.HashMap;
import java.util.UUID;

@RestController
public class TestController {

    @PostMapping("/auth/login")
    @ResponseBody
    public HashMap<String, String> login() {
        HashMap result = new HashMap();
        result.put("acessToken", UUID.randomUUID().toString());
        result.put("code", "1001");

        return result;
    }



    @PostMapping("/user/getUser")
    @DenyAll
    @ResponseBody
    public HashMap<String, String> getUser() {
        HashMap result = new HashMap();
        result.put("acessToken", UUID.randomUUID().toString());
        result.put("code", "1012");

        return result;
    }


    @PostMapping("/user/getUser1")
    @PermitAll
    @ResponseBody
    public HashMap<String, String> getUser1() {
        HashMap result = new HashMap();
        result.put("acessToken", UUID.randomUUID().toString());
        result.put("code", "1012");

        return result;
    }


    @PostMapping("/user/getUser2")
    @ResponseBody
    public HashMap<String, String> getUser2() {
        HashMap result = new HashMap();
        result.put("acessToken", UUID.randomUUID().toString());
        result.put("code", "1012");

        return result;
    }



    @PostMapping("/user/getUser3")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public HashMap<String, String> getUser3() {
        HashMap result = new HashMap();
        result.put("acessToken", UUID.randomUUID().toString());
        result.put("code", "1012");

        return result;
    }


    @PostMapping("/user/getUser4")
    @PreAuthorize("hasRole('FLEET')")
    @ResponseBody
    public HashMap<String, String> getUser4() {
        HashMap result = new HashMap();
        result.put("acessToken", UUID.randomUUID().toString());
        result.put("code", "1012");

        return result;
    }


    @PostMapping("/user/getUser5")
    @PreAuthorize("hasRole('CONSIGNOR')")
    @ResponseBody
    public HashMap<String, String> getUser5() {
        HashMap result = new HashMap();
        result.put("acessToken", UUID.randomUUID().toString());
        result.put("code", "1012");

        return result;
    }


    @PostMapping("/user/getUser6")
    @PreAuthorize("hasAuthority('code001')")
    //@PreAuthorize("hasRole('code001')")
    @ResponseBody
    public HashMap<String, String> getUser6() {
        HashMap result = new HashMap();
        result.put("acessToken", UUID.randomUUID().toString());
        result.put("code", "1012");

        return result;
    }
}
