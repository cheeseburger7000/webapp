package com.shaohsiung.web;

import com.alibaba.fastjson.JSONObject;
import com.shaohsiung.web.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxJsonServlet", urlPatterns = "/json")
public class AjaxJsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 发送post请求携带表单数据时，无法解析。通过查看http请求报文定位出错原因。
        // 获取请求参数
        String userName = request.getParameter("userName");
        Integer age = Integer.parseInt(request.getParameter("age"));
        String city = request.getParameter("city");

//        User shaohsiung = User.builder().userName("shaohsiung").age(16).city("厦门").build();
        User shaohsiung = User.builder().userName(userName).age(age).city(city).build();
        System.out.println("【AjaxJsonServlet】doPost - User：" + shaohsiung);

        // 将对象序列化为json串
        String result = JSONObject.toJSONString(shaohsiung);

        // 获取客户端请求头 ContentType
        String clientContentType = request.getContentType();
        System.out.println("【AjaxJsonServlet】doPost - clientContentType：" + clientContentType);

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String userName = request.getParameter("userName");
        Integer age = Integer.parseInt(request.getParameter("age"));
        String city = request.getParameter("city");

        User john = User.builder().userName(userName).age(age).city(city).build();
        System.out.println("【AjaxJsonServlet】doGet - User：" + john);

        String result = JSONObject.toJSONString(john);

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(result);
    }
}
