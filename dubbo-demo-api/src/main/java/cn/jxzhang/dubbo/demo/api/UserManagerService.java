package cn.jxzhang.dubbo.demo.api;

import cn.jxzhang.dubbo.demo.domain.User;

import java.util.List;

/**
 * UserManagerService
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public interface UserManagerService {

    User getUserById(Integer id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    List<User> users();
}
