package com.xx.service.impl;

import com.xx.entity.Course;
import com.xx.mapper.CourseMapper;
import com.xx.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * description: 课程service实现类
 * @author 钟晓锋（xiaofeng.zhong@ucarinc.com）
 * @date 2019-07-24 10:23
 * @version 1.0
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    CourseMapper courseMapper;


    @Override
    public List<Course> selectAllCourse() {
        return courseMapper.selectAll();
    }

}
