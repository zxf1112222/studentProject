package com.xx.controller;

import com.xx.entity.Student;
import com.xx.service.StudentService;
import com.xx.utils.SetUTF8;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
/**
 * description: 学生控制类
 * @author 钟晓锋（xiaofeng.zhong@ucarinc.com）
 * @date 2019-07-24 10:23
 * @version 1.0
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/selectAllStudent")
    public void selectAllUser(HttpServletResponse response) throws IOException {
        List<Student> students = studentService.selectAllStudent();
        SetUTF8.set(response);
        List<String> studentList = new ArrayList<>();
        for (Student student : students) {
            JSONObject jsonObject = JSONObject.fromObject(student);
            studentList.add(jsonObject.toString());
        }
        response.getWriter().print(studentList);
    }

    @RequestMapping(value = "updateStudent")
    public void updateStudent(Student student, HttpServletResponse response, HttpServletRequest request) throws IOException {
        SetUTF8.set(response, request);
        System.out.println(student);
        try {
            if (studentService.updateStudent(student)) {
                response.getWriter().print("修改成功！");
            } else {
                response.getWriter().print("修改失败！");
            }
        } catch (Exception e) {
            response.getWriter().print("修改出现错误！");
        }
    }

    @RequestMapping("handleDeleteStudent")
    public void handleDeleteStudent(Student student, HttpServletRequest httpServletRequest, HttpServletResponse response) throws UnsupportedEncodingException {
        SetUTF8.set(response, httpServletRequest);
        studentService.deleteStudent(student);
    }
}
