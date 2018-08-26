package cn.jxzhang.dubbo.consumer;

import cn.jxzhang.dubbo.demo.api.TimeoutService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * MainTest
 *
 * @author zhangjiaxing
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath*:consumer.xml")
public class TimeoutTest {

    @Resource
    private TimeoutService timeoutService;

    @Test(expected = com.alibaba.dubbo.rpc.RpcException.class)
    public void shouldThrowTimeoutException() {
        timeoutService.shouldTimeout();
    }

    @Test
    public void shouldNotTimeout() {
        timeoutService.shouldNotTimeout();
    }
}
