package com.meek.demo.filter;

import com.alibaba.fastjson.JSONObject;
import com.meek.demo.dto.ObjectRestResponse;
import com.meek.demo.dto.constant.CodeStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 权限拒绝-处理器
 */
public class SecurityAuthAccessDeniedHandler implements AccessDeniedHandler {
    private static ObjectRestResponse restResponse = new ObjectRestResponse(CodeStatus.PARAM_ACCESS_FORBIDDEN);
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        System.out.println("CustomBasicAuthenticationFilter.onUnsuccessfulAuthentication");
        String jsonString = JSONObject.toJSONString(restResponse);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(jsonString);
    }
}
