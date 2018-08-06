package cn.jxzhang.dubbo.consumer;

import cn.jxzhang.dubbo.demo.api.GreetingService;
import cn.jxzhang.dubbo.demo.api.MutiServiceImplication;
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

    @Resource
    private MutiServiceImplication mutiServiceImplication;

    @Test
    public void test() {
        String hello = greetingService.sayHello("world"); // 执行远程方法
        System.out.println( hello ); // 显示调用结果
    }

    @Test
    public void testSaveUser() {
        userManagerService.saveUser(new User(1, "User1", 21, new Date()));
        userManagerService.saveUser(new User(2, "User2", 21, new Date()));
        userManagerService.saveUser(new User(3, "User3", 23, new Date()));
        userManagerService.saveUser(new User(4, "User4", 25, new Date()));
        userManagerService.saveUser(new User(5, "User5", 22, new Date()));
        userManagerService.saveUser(new User(6, "User6", 21, new Date()));
        userManagerService.saveUser(new User(7, "User7", 21, new Date()));
        userManagerService.saveUser(new User(8, "User8", 28, new Date()));
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
        User userById2 = userManagerService.getUserById(1);
        User userById3 = userManagerService.getUserById(1);
        System.out.println(userById);
        System.out.println(userById2);
        System.out.println(userById3);
    }

    @Test
    public void testMutiServiceImplication() {
        mutiServiceImplication.printServiceName();
    }
}
