package com.mqa.demo.thymeleaf.dao;

import com.mqa.demo.thymeleaf.domain.User;

import java.util.List;

/**
 * @author mengqa
 * @create 2018-05-04 14:50
 **/
public interface UserDao {

    User saveOrUpdate(User user);

    void delete(Long id);

    User getUserById(Long id);

    List<User> list();

}
