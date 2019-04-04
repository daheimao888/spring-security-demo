package com.meek.demo.filter;

import com.meek.demo.jwt.JwtUser;
import com.meek.demo.jwt.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring-Security 过滤器
 */
public class SecurityAuthenticationTokenFilter extends GenericFilterBean {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("JwtAuthenticationTokenFilter.doFilter");
        final HttpServletRequest httpRequest = (HttpServletRequest)request;

        //extract token from header
        final String accessToken = httpRequest.getHeader("refreshToken");
        //globalToken
        final String globalToken = httpRequest.getHeader("token");

        if (!StringUtils.isEmpty(accessToken)) {
            // accessToken请求业务系统
            //
            //get and check whether token is valid ( from DB or file wherever you are storing the token)

            //Populate SecurityContextHolder by fetching relevant information using token
            JwtUser jwtUser = JwtUserFactory.create();
            final UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(jwtUser, null, jwtUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }else if(!StringUtils.isEmpty(globalToken)){
            // globalToken请求66快车
        }else{
            //游客权限
            JwtUser jwtUser = JwtUserFactory.createNoTokenUser();
            final UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(jwtUser, null, jwtUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }
}
