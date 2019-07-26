package com.xx.service;

import com.xx.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * description: 学生service实现接口
 * @author 钟晓锋（xiaofeng.zhong@ucarinc.com）
 * @date 2019-07-24 10:23
 * @version 1.0
 */
@SuppressWarnings("ALL")
@Service
public interface StudentService {
    /**
     * 获取所有学生
     * @param
     * @return List<Student>
     */
    List<Student> selectAllStudent();

    /**
     * 更新传入学生的信息
     * @param student
     * @return 成功与否标志
     */
    boolean updateStudent(Student student);

    /**
     * 删除传入学生
     * @param student
     * @return null
     */
    void deleteStudent(Student student);
}
