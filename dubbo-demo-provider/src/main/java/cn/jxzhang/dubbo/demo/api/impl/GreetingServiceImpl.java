package cn.jxzhang.dubbo.demo.api.impl;

import cn.jxzhang.dubbo.demo.api.GreetingService;
import org.springframework.stereotype.Component;

/**
 * GreetingService
 *
 * @author zhangjiaxing
 * @version 1.0
 */
@Component
public class GreetingServiceImpl implements GreetingService {

    public String sayHello(String name) {
        System.out.println("received message: " + name);
        return "Hello " + name;
    }
}