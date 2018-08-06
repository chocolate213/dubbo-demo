package cn.jxzhang.dubbo.demo.api;

/**
 * MutiServiceImplication
 *
 * @author zhangjiaxing
 */
public interface MutiServiceImplication {

    default void printServiceName() {
        System.out.println(this.getClass());
    }
}
