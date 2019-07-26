package com.xx.service;

import com.xx.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * description: 课程service实现接口
 * @author 钟晓锋（xiaofeng.zhong@ucarinc.com）
 * @date 2019-07-24 10:23
 * @version 1.0
 */
@Service
public interface CourseService {
    /**
     * description:<方法说明>
     * @author钟晓锋（xiaofeng.zhong.ucarinc.com）
     * @date: 2019/7/24 12:44
     * @param: []
     * @return: java.util.List<com.xx.entity.Course>
     */
    List<Course> selectAllCourse();

}
