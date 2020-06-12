package com.mzc.dao;

import com.mzc.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mazhicheng
 * @date 2020/5/12 - 11:59
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);

}
