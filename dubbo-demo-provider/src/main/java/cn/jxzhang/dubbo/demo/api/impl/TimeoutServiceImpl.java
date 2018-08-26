package cn.jxzhang.dubbo.demo.api.impl;

import cn.jxzhang.dubbo.demo.api.TimeoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * TimeoutServiceImpl
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public class TimeoutServiceImpl implements TimeoutService {

    private static final Logger log = LoggerFactory.getLogger(TimeoutServiceImpl.class);

    @Override
    public void shouldTimeout() {

        log.info("sleep for 3 seconds...");

        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void shouldNotTimeout() {}
}
