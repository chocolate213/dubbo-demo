package cn.jxzhang.dubbo.consumer;

import cn.jxzhang.dubbo.demo.api.GreetingService;
import cn.jxzhang.dubbo.demo.api.UserManagerService;
import cn.jxzhang.dubbo.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * MainTest
 *
 * @author zhangjiaxing
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath*:consumer.xml")

public class MainTest {

    /**
     * dubbo 中定义的服务需要使用 {@link Resource} 注解注入，默认为byName，不能使用
     * {@link org.springframework.beans.factory.annotation.Autowired} ，否则idea会报错
     *
     */
    @Resource
    private GreetingService greetingService;

    @Resource
    private UserManagerService userManagerService;

    @Test
    public void test() {
        String hello = greetingService.sayHello("world"); // 执行远程方法
        System.out.println( hello ); // 显示调用结果
    }

    @Test
    public void testSaveUser() {
        userManagerService.saveUser(new User(2, "liSi", 22, new Date()));
    }

    @Test
    public void testSaveUser2() {
        userManagerService.saveUser(new User(1, "zhangSan", 22, new Date()));
    }

    @Test
    public void testUpdateUser() {
        userManagerService.updateUser(new User(1, "ZhangSanSan", 22, new Date()));
    }

    @Test
    public void testDeleteUser() {
        userManagerService.deleteUser(new User(1));
    }

    @Test
    public void testUserList() {
        List<User> users = userManagerService.users();
        System.out.println(users);
    }

    @Test
    public void testGetUserById() {
        User userById = userManagerService.getUserById(1);
        System.out.println(userById);
    }
}
