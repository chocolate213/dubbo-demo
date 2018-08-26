# Dubbo Demo

## Example

1. 启动时检查： 通过配置在启动时检查服务是否可用

2. 服务提供者直连：测试环境下不通过测试中心直接连接服务提供者

3. 多协议：不同的服务可以配置不同的协议：大数据用短连接协议，数据大并发用长连接协议

4. 多注册中心：不同的服务注册到不同的注册中心

5. 服务分组：一个服务有不同的实现时可以使用服务分组来指定不同实现，消费端也可以使用分组来指定需要调用的实现

6. 多版本：使用接口端口号

7. 参数验证：JSR303

8. 接口结果缓存：lru threadlocal jcache

9. 回声测试：所有服务自动实现EchoService接口，强制转换类型之后就可以进行测试服务是否可用

10. 上下文信息：RpcContext对象可以获取上下文信息

11. 异步调用：返回Future对象

12. 参数回调：调用成功后调用指定回调接口中的方法

13. 事件通知：服务消费者可以在调用事件指定回调接口：调用失败抛出异常时，调用成功返回时

14. 本地存根：消费端可以设置代理对象实现API接口，来控制远程服务的响应、异常处理、ThreadLocal缓存等

``` java 
    package com.foo;
    public class BarServiceStub implements BarService { 
        private final BarService barService;
        
        // 构造函数传入真正的远程代理对象
        public (BarService barService) {
            this.barService = barService;
        }
     
        public String sayHello(String name) {
            // 此代码在客户端执行, 你可以在客户端做ThreadLocal本地缓存，或预先验证参数是否合法，等等
            try {
                return barService.sayHello(name);
            } catch (Exception e) {
                // 你可以容错，可以做任何AOP拦截事项
                return "容错数据";
            }
        }
    }
```

15. *** 本地伪装：当服务提供方全部挂掉后，客户端不抛出异常，而是通过 Mock 数据返回授权失败。

16. 延迟暴露接口：设置暴露接口的延迟时间，或者是等待Spring容器初始化完成之后在进行暴露接口

17. 并发控制：控制接口的并发请求数量

18. 连接数量：控制服务端连接数量 

19. 令牌验证：防止消费者绕过注册中心访问提供者

20. 访问日志：可以配置dubbo访问日志

21. 修改序列化方式：可以修改为kryo等

## BUG FIX

1. 如果使用Zookeeper作为注册中心，需要配置如下依赖：

```xml
    <!-- dubbo zookeeper 必须依赖 -->
    <dependencyManagement>
        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
            <version>3.4.9</version>
        </dependency>
    
        <dependency>
            <groupId>org.apache.curator</groupId>
            <artifactId>curator-framework</artifactId>
            <version>2.12.0</version>
        </dependency>
    </dependencyManagement>
```

2. 配置覆盖规则：

* 方法级优先，接口级次之，全局配置再次之。
* 如果级别一样，则消费方优先，提供方次之。

3. 最佳用法

  - 在Provider端配置Consumer端需要的属性（服务提供者最清楚性能参数）
  
      0. timeout方法调用超时时间
      1. retries 失败重试次数
      2. loadbalance: 负载均衡算法
      3. actives：最大并发调用限制
      4. threads 服务线程池大小
      5. executes 一个服务提供者并行执行请求上限

  - dubbo缓存文件：这个文件会缓存注册中心的列表和服务提供者列表。
  
   <dubbo:registry file=”${user.home}/output/dubbo.cache” />

3. best practice

- 每个接口都需要配置版本号，为后续不兼容升级提供可能

4. dubbo所有可选依赖都需要手动添加：

http://dubbo.apache.org/zh-cn/docs/user/dependencies.html