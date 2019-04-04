package com.meek.demo.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    private JwtUserFactory() {
    }

    public static JwtUser create() {
        System.out.println("JwtUserFactory.create-----");
        //权限 ROLE_ADMIN,ROLE_FLEET
        List<String> roles = new ArrayList<>();
        //role
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_FLEET");
        //permission
        roles.add("code001");
        return new JwtUser(
                "1",
                "test",
                "test",
                "test@163.com",
                mapToGrantedAuthorities(/*user.getRoles()*/roles),
                new Date()
        );
    }


    public static JwtUser createNoTokenUser() {
        System.out.println("JwtUserFactory.create-----");
        //权限 ROLE_ADMIN,ROLE_FLEET
        List<String> roles = new ArrayList<>();
/*        roles.add("ROLE_ADMIN");
        roles.add("ROLE_FLEET");*/

        return new JwtUser(
                "1",
                "test",
                "test",
                "test@163.com",
                mapToGrantedAuthorities(/*user.getRoles()*/roles),
                new Date()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
