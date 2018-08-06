package cn.jxzhang.dubbo.demo.api.impl;

import cn.jxzhang.dubbo.demo.api.ContextService;
import com.alibaba.dubbo.rpc.RpcContext;

/**
 * ContextServiceImpl
 *
 * @author zhangjiaxing
 */
public class ContextServiceImpl implements ContextService {
    @Override
    public void getContextInfo() {
        // 本端是否为提供端，这里会返回true
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        System.out.println("is provider side: " + isProviderSide);
        // 获取调用方IP地址
        String clientIP = RpcContext.getContext().getRemoteHost();

        System.out.println("client ip");
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String application = RpcContext.getContext().getUrl().getParameter("application");
        // 注意：每发起RPC调用，上下文状态会变化

        // 此时本端变成消费端，这里会返回false
        boolean isProviderSide2 = RpcContext.getContext().isProviderSide();
    }
}
