package com.meek.demo.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String globalToken) throws UsernameNotFoundException {
        //User user = userRepository.findByUsername(username);
        System.out.println("JwtUserDetailsServiceImpl-----");
        if (false/*user == null*/) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", ""/*username*/));
        } else {
            return JwtUserFactory.create(/*user*/);
        }
    }
}
