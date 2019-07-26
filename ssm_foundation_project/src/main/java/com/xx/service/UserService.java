package com.xx.service;

import com.xx.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service/**
 * description: 用户service实现类
 * @author 钟晓锋（xiaofeng.zhong@ucarinc.com）
 * @date 2019-07-24 10:23
 * @version 1.0
 */
public interface UserService {
    /**
     * 获取所有用户
     * @param
     * @return List<user>
     */
    List<User> selectAllUser();

    /**
     * 查询某个账号的用户
     * @param snum
     * @return user
     */
    User selectUserBySnum(String snum);
}
