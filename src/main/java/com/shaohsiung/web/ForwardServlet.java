package com.shaohsiung.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 转发
 */
@WebServlet(name = "ForwardServlet", urlPatterns="/forward")
public class ForwardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println("【doGet】name: " + name);

        request.setAttribute("name", name);

        request.getRequestDispatcher("/log").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println("【doGet】name: " + name);

        request.setAttribute("name", name);

        // 转发到jsp。jsp本质上就是一个“都是输出的servlet”
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/forward.jsp");
//        requestDispatcher.forward(request, response);

        // 转发到servlet
        // *我收获了一个重要的结论：用户发送get请求访问servlet，servlet默认以get转发。若用户发送post请求，那么servlet默认以post转发。
        //                                          即servlet转发方式以用户的请求类型保持一致。
        request.getRequestDispatcher("/log").forward(request, response);
    }
}
