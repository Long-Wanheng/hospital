package com.agoi.service;

import com.agoi.pojo.User;

/**
 * @author: agoi
 * @date 2019/09/18 17:54
 */
public interface UserService {
    User login(String uLoginName, String uPassword);
}
