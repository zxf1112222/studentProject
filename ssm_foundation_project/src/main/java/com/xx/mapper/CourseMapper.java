package com.xx.mapper;

import com.xx.entity.Course;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
/**
 * description: 课程mapper接口
 * @author 钟晓锋（xiaofeng.zhong@ucarinc.com）
 * @date 2019-07-24 10:23
 * @version 1.0
 */
@Repository
public interface CourseMapper extends Mapper<Course> {
   

    public  String ss(int a,int b);
}