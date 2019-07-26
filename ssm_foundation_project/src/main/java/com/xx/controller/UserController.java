package com.xx.controller;

import com.xx.entity.User;
import com.xx.service.UserService;
import com.xx.utils.MD5;
import com.xx.utils.SetUTF8;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * description: 用户控制类
 * @author 钟晓锋（xiaofeng.zhong@ucarinc.com）
 * @date 2019-07-24 10:23
 * @version 1.0
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/selectAllUser")
    public void selectAllUser(HttpServletResponse response) throws IOException {
        List<User> users = userService.selectAllUser();
        SetUTF8.set(response);
        List<String> userList = new ArrayList<>();
        for (User user : users) {
            JSONObject jsonObject = JSONObject.fromObject(user);
            userList.add(jsonObject.toString());
        }
        response.getWriter().print(userList);
    }

    @RequestMapping(value = "login")
    public void login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String snum = request.getParameter("snum");
        String password = request.getParameter("password");
        System.out.println(snum + "=" + password);
        //MD5加密，生成32位 小写字母
        password = MD5.md5(password);
        User user = userService.selectUserBySnum(snum);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                System.out.println("登陆成功");
                System.out.println("loginid:" + user.getId());
                session.setAttribute("user", user);
                response.getWriter().print("true");
            } else {
                response.getWriter().print("false");
            }
        } else {
            response.getWriter().print("false");
        }
    }
}
