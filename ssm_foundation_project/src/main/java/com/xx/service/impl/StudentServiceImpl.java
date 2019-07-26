package com.xx.service.impl;

import com.xx.entity.Student;
import com.xx.mapper.StudentMapper;
import com.xx.service.StudentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
/**
 * description: 学生service实现类
 * @author 钟晓锋（xiaofeng.zhong@ucarinc.com）
 * @date 2019-07-24 10:23
 * @version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;

    @Override
    public List<Student> selectAllStudent() {
        return studentMapper.selectAll();
    }

    @Override
    public boolean updateStudent(Student student) {
/* 这里是自己写的更新方法
 studentMapper.updateStudent(student);*/
        int isBoolean = studentMapper.updateByPrimaryKeySelective(student);
        if (isBoolean == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void deleteStudent(Student student) {
        studentMapper.delete(student);
    }
}
