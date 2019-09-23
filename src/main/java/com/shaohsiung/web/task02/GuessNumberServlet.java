package com.shaohsiung.web.task02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GuessNumberServlet", urlPatterns = "/guess")
public class GuessNumberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户猜的值
        Integer number = Integer.parseInt(request.getParameter("number"));
        // 获取随机值
        Integer random = (Integer) request.getSession().getAttribute("random");

        int consume = (int) request.getSession().getAttribute("consume");
        String message;
        long time = 0;
        if (!"".equals(number) && random.equals(number)) {
            message = "恭喜您！猜对了";
            consume++;
            // 获取beginTime进行计算耗时
            long beginTime = (long) request.getSession().getAttribute("beginTime");
            long endTime = System.currentTimeMillis();
            time = endTime - beginTime;
        } else if ((!"".equals(number) && random > number)) {
            message = "太小了";
            consume++;
        } else if ((!"".equals(number) && random < number)) {
            message = "太大了";
            consume++;
        } else {
            message = "出错了";
            consume++;
        }

        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("time", time);
        request.getSession().setAttribute("consume", consume);

        response.sendRedirect("/guess");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/guessNumber.jsp").forward(request, response);
    }
}
