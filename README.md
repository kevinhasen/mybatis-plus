# mybatis-plus入门案例

是一个 [MyBatis](http://www.mybatis.org/mybatis-3/) 的增强工具



## 依赖注意

依赖.2.1.RELEASE为主

Mybatis 及 Mybatis-Spring 依赖请勿加入项目配置，以免引起版本冲突！！！  

添加配置

```yaml
mybatis-plus:  # 日志,显示sql语句
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```



## 乐观锁和分页

旧版的已经过期,换新版

```java
  /**
     * 新版乐观锁和分页
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //添加乐观锁
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        //添加分页
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
```



## 常用查询语句

常用方法

（1）eq、ne         =,  !=

（2）ge、gt、le、lt     >, >= ,< ,<=

（3）between        范围,     ?   or  ?

（4）like         模糊匹配      %?%

（5）orderByDesc      排序倒叙

（6）select                 显示查询的字段





多个使用,默认是and





## 特别注意

自动填充需要实现元对象处理器接口

逻辑删除只是修改了状态,不是真正的删除
