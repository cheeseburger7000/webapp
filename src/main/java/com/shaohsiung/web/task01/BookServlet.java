package com.shaohsiung.web.task01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;

@WebServlet(name = "BookServlet", urlPatterns = "/book")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("【BookServlet】doPost");

        String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "utf-8");
        String price = new String(request.getParameter("price").getBytes("ISO-8859-1"), "utf-8");
        String detail = new String(request.getParameter("detail").getBytes("ISO-8859-1"), "utf-8");

        Book book = Book.builder().name(name).detail(detail).price(new BigDecimal(price)).build();

        List<Book> bookList = (List) request.getSession().getAttribute("bookList");

        if (bookList == null) {
            // 第一次添加书籍
            bookList = new Vector<>();
        }
        bookList.add(book);

        request.getSession().setAttribute("bookList", bookList);

        // 重定向到展示页面
        response.sendRedirect("/book");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("【BookServlet】doGet");

        // 转发到添加书籍页面
        request.getRequestDispatcher("/WEB-INF/jsp/book.jsp").forward(request, response);
    }
}
