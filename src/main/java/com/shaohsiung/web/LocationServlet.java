package com.shaohsiung.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "LocationServlet", urlPatterns = "/location")
public class LocationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("【realPath】" + realPath);

//        writeFile2ClassPath(request);
//        readFileFromClassPath(request);

        testGetResourceAsStream(request);
    }

    private void testGetResourceAsStream(HttpServletRequest request) throws IOException {
        int b;
        try (InputStream in = request.getSession().getServletContext().getResourceAsStream("/WEB-INF/classes/message.txt");) {
            while ((b = in.read()) != -1) {
                System.out.println((char) b);
            }
        }
    }

    private void readFileFromClassPath(HttpServletRequest request) throws IOException {
        String classPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/");
        String messageTxtPath = classPath + "\\message.txt";
        System.out.println("【LocationServlet】doGet " + messageTxtPath);

        int b;
        try (InputStream in = new FileInputStream(messageTxtPath)) {
            while ((b = in.read()) != -1) {
                System.out.println((char) b);
            }
        }
    }

    private void writeFile2ClassPath(HttpServletRequest request) throws IOException {
        // 获取classpath中的user.txt文件，写入shaohsiung
        String classPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/");
        String userTxtPath = classPath + "\\user.txt";
        File userTxt = new File(userTxtPath);

        System.out.println("【LocationServlet】doGet " + userTxtPath);

        try (OutputStream out = new FileOutputStream(userTxt)) {
            out.write("shaohsiung".getBytes());
        }
    }
}
