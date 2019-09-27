package com.enestuncay.security;

import com.enestuncay.entity.User;
import com.enestuncay.todolist.HomeController;
import com.enestuncay.todolist.LoginController;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@Scope
public class LoginFilter implements Filter {

    public static User user = null;



    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;


        if(req.getRequestURI().contains("login")) {
            chain.doFilter(request, response);
            return;
        }

        if(req.getRequestURI().contains("register")) {
            chain.doFilter(request, response);
            return;
        }

        if(req.getRequestURI().contains("addUser")){
            chain.doFilter(request, response);
            return;
        }
        if(req.getRequestURI().contains("logout")){
            chain.doFilter(request, response);
            return;
        }
        if(req.getRequestURI().contains("reg")){
            chain.doFilter(request, response);
            return;
        }
        if(req.getRequestURI().contains("controlUser")){
            chain.doFilter(request, response);
            return;
        }


        User user = (User)req.getSession().getAttribute("user");
        this.user = user;

        if(user != null) {
            chain.doFilter(request, response);
            return;
        }
        else {
            res.sendRedirect(LoginController.url + "/login");
        }

        //chain.doFilter(request, response);
    }


    public void init(FilterConfig fConfig) throws ServletException {

    }


}
