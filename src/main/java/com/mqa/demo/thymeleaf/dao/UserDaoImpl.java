package com.mqa.demo.thymeleaf.dao;

import com.mqa.demo.thymeleaf.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author mengqa
 * @create 2018-05-04 14:51
 **/
@Repository
public class UserDaoImpl implements UserDao {

    /**
     * 记数（模拟实现唯一id）
     */
    private static AtomicLong counter = new AtomicLong();

    /**
     * 内存模拟实现
     */
    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();

    @Override
    public User saveOrUpdate(User user) {
        Long id = user.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id, user);
        return user;
    }

    @Override
    public void delete(Long id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> list() {
        return new ArrayList<User>(this.userMap.values());
    }
}
