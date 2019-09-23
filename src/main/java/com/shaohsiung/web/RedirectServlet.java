package com.shaohsiung.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet(name = "RedirectServlet", urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("【RedirectServlet】doPost");

        // post请求重定向之后，客户端发送get请求，而不是post请求。
        response.sendRedirect("/log");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("【RedirectServlet】doGet");

        // 1.重定向到站外
        response.sendRedirect("http://www.baidu.com");

        // 2.重定向到站内servlet
//        response.sendRedirect("/log");

        // 重定向到jsp
        //response.sendRedirect("/WEB-INF/jsp/index.jsp"); // 无法重定向到WEB-INF。因为重定向后的http请求由客户端发起。
    }
}
