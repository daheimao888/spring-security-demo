package com.meek.demo.config;

import com.meek.demo.filter.SecurityAuthAccessDeniedHandler;
import com.meek.demo.filter.SecurityAuthenticationTokenFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
;

/**
 * Spring-Security 安全配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        System.out.println("WebSecurityConfig2");
        httpSecurity
                // 由于使用的是JWT，我们这里不需要csrf
                .csrf().disable()

                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .authorizeRequests()

                // 对于获取token的rest api要允许匿名访问
                .antMatchers("/auth/**").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated();

        //权限拒绝后处理
        SecurityAuthAccessDeniedHandler deniedHandler = new SecurityAuthAccessDeniedHandler();
        httpSecurity.exceptionHandling().accessDeniedHandler(deniedHandler);

        //过滤器
        final SecurityAuthenticationTokenFilter filter = new SecurityAuthenticationTokenFilter();
        httpSecurity.addFilterBefore(filter, BasicAuthenticationFilter.class);

        // 禁用缓存
        httpSecurity.headers().cacheControl();


    }


}
