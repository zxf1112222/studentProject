package com.xx.service.impl;

import com.xx.entity.User;
import com.xx.mapper.UserMapper;
import com.xx.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * description: 用户service实现类
 * @author 钟晓锋（xiaofeng.zhong@ucarinc.com）
 * @date 2019-07-24 10:23
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAll();
//     下面是自己写的mapper
//      return courseMapper.selectAllCourse();
    }

    @Override
    public User selectUserBySnum(String snum) {
        User user = new User();
        user.setSnum(snum);
        return userMapper.selectOne(user);
    }

}
