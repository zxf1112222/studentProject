package com.xx.controller;

import com.xx.entity.Course;
import com.xx.service.CourseService;
import com.xx.utils.SetUTF8;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * description: 课程控制类
 * @author 钟晓锋（xiaofeng.zhong@ucarinc.com）
 * @date 2019-07-24 10:23
 * @version 1.0
 */
@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("selectAllCourse")
    public void selectAllCourse(HttpServletResponse response) throws IOException {
        SetUTF8.set(response);
        response.addHeader("Access-Control-Allow-Origin", "*");
        List<Course> courses = courseService.selectAllCourse();
        List<String> courseList = new ArrayList<>();
        for (Course cour : courses) {
            JSONObject jsonObject = JSONObject.fromObject(cour);
            courseList.add(jsonObject.toString());
        }
        response.getWriter().print(courseList);
    }

}
