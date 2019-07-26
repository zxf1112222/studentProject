package com.xx.utils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.UnsupportedEncodingException;
/**
 * Description: 解决乱码问题
 *
 * @Author 钟晓锋（xiaofeng.zhong@ucarinc.com）
 * @Date 2019-07-24 11:15
 * @Version 1.0
 */
public class SetUTF8 {
    public static void set(ServletResponse response, ServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
    }

    public static void set(ServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=utf-8");
    }

}
