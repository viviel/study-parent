# 定义lambda Converter报错

## 个人pr：

https://github.com/spring-projects/spring-boot/pull/22885

实现原理：

通过应用层（spring boot）解析出范型信息并注册到容器中

## 疑似最终解决方案：

https://github.com/spring-projects/spring-framework/releases/tag/v5.3.9

https://github.com/spring-projects/spring-framework/issues/27160

猜测：

通过底层spring framework实现特性支持，在生成Bean的时候就会把范型信息注册到BeanDefinition中

## 后续需要跟进spring框架查看问题是否解决以及怎么解决

