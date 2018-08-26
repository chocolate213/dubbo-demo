package cn.jxzhang.dubbo.demo;

import cn.jxzhang.dubbo.demo.domain.User;
import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * KryoSerializationOptimizer
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public class KryoSerializationOptimizer implements SerializationOptimizer {

    @Override
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new ArrayList<>();
        classes.add(User.class);
        return classes;
    }
}
