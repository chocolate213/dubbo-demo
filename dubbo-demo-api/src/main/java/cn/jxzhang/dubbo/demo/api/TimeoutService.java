package cn.jxzhang.dubbo.demo.api;

/**
 * TimeoutService
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public interface TimeoutService {

    void shouldTimeout();

    void shouldNotTimeout();
}
