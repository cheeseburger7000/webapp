package com.shaohsiung.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

public class CustomReuqest extends HttpServletRequestWrapper {
    public CustomReuqest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String parameter = getRequest().getParameter(name);
        String result = null;
        try {
            result = new String(parameter.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println("result:" + result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
