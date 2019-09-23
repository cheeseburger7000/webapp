package com.shaohsiung.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理get和post乱码
 */
public class CharacterEncodingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8"); // OK
        request.setCharacterEncoding("UTF-8"); // OK
        String name = request.getParameter("name");
        System.out.println("【doPost】name: " + name);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决get乱码
        String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "utf-8");
        System.out.println("【doGet】name: " + name);
    }
}
