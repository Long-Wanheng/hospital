package com.agoi.service.impl;

import com.agoi.mapper.UserMapper;
import com.agoi.pojo.User;
import com.agoi.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: agoi
 * @date 2019/09/18 17:55
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String uLoginName, String uPassword) {
        Map map = new HashMap();
        map.put("uLoginName", uLoginName);
        User user = userMapper.login(map);
        if (user!=null&&uPassword.equals(user.getuLoginName())){
            return user;
        }
        return null;
    }
}
