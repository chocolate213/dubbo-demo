package cn.jxzhang.dubbo.demo.api.impl;

import cn.jxzhang.dubbo.demo.api.UserManagerService;
import cn.jxzhang.dubbo.demo.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * UserManagerServiceImpl
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public class UserManagerServiceImpl implements UserManagerService {

    private final ConcurrentHashMap<Integer, User> userList = new ConcurrentHashMap<>();

    public UserManagerServiceImpl() {}

    @Override
    public User getUserById(Integer id) {
        System.out.println("get user by id: " + id);
        return userList.get(id);
    }

    @Override
    public void saveUser(User user) {
        System.out.println("save user: " + user);
        userList.put(user.getId(), user);
    }

    @Override
    public void updateUser(User user) {
        System.out.println("update user: " + user);
        userList.put(user.getId(), user);
    }

    @Override
    public void deleteUser(User user) {
        System.out.println("delete user: " + user);
        userList.remove(user.getId());
    }

    @Override
    public List<User> users() {
        System.out.println("get user list (version: 1.0.1): " + userList);
        return new ArrayList<>(userList.values());
    }
}
