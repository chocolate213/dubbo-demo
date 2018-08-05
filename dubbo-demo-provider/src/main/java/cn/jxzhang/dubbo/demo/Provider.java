package cn.jxzhang.dubbo.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Provider
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public class Provider {
    public static void main(String[] args) throws IOException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        TimeUnit.DAYS.sleep(1);
    }
}
