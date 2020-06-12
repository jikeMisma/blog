package com.mzc.service;

import com.mzc.po.User;

/**
 * @author mazhicheng
 * @date 2020/5/12 - 11:56
 */
public interface UserService {

    User checkUser(String username, String password);
}
