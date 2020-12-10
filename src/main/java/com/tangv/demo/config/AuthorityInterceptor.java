package com.tangv.demo.config;

import com.tangv.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/3/7 3:15 下午
 */
/*@Component
public class AuthorityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            writeContent(response,"请登录");
        }
        String requestURI = request.getRequestURI();
        if (user.getAuthority().equals("p1") && requestURI.contains("/r/r1")){
            return true;
        }
        if (user.getAuthority().equals("p2") && requestURI.contains("/r/r2")){
            return true;
        }
        log.error("无此权限！");
        return false;
    }

    private void writeContent(HttpServletResponse response, String msg) {
        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter pw = response.getWriter();
            pw.print(msg);
            pw.close();
            response.resetBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/
