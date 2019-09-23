package com.shaohsiung.web.task02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SelectLevelServlet", urlPatterns = "/level")
public class SelectLevelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取难度
        String level = request.getParameter("level");
        System.out.println("【SelectLevelServlet】doPost-用户选择难度：" + level);

        int randomByLevel = getRandomByLevel(level);
        request.getSession().setAttribute("level", level);
        request.getSession().setAttribute("random", randomByLevel);
        request.getSession().setAttribute("beginTime", System.currentTimeMillis());

        request.getSession().setAttribute("message", null);
        request.getSession().setAttribute("time", 0);
        request.getSession().setAttribute("consume", 0);

        request.getRequestDispatcher("/WEB-INF/jsp/guessNumber.jsp").forward(request, response);
    }

    /**
     * 根据level生成随机值
     * @param level
     * @return 若返回-1，则说明出错。
     */
    private int getRandomByLevel(String level) {
        int result;
        switch (level) {
            case "0":
                result= (int) (Math.random()*10 + 1);
                break;
            case "1":
                result= (int) (Math.random()*30 + 1);
                break;
            case "2":
                result= (int) (Math.random()*50 + 1);
                break;
            default:
                result = -1;
                System.out.println("错误！");
                break;
        }
        return result;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/selectLevel.jsp").forward(request, response);
    }
}
