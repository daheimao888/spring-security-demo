package com.meek.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import java.util.HashMap;
import java.util.UUID;

@PreAuthorize("hasRole('FLEET')")
@RestController
public class Test1Controller {




    @PostMapping("/user1/getUser2")
    @ResponseBody
    public HashMap<String, String> getUser2() {
        HashMap result = new HashMap();
        result.put("acessToken", UUID.randomUUID().toString());
        result.put("code", "1012");

        return result;
    }




}
