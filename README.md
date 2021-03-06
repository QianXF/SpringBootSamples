# SpringBootSamples
spring-boot示例工程，包含了spring-boot的基本功能

## 一、使用步骤
1.将src/main/resources/logback.xml.sample文件复制到该目录下命名为logback.xml
2.将src/main/resources/application.properties.sample文件复制到该目录下命名为application.properties

## 二、模块说明
### 1.spring-boot-starter-web
支持 Web 应用开发，包含 Tomcat 和 spring-mvc。
可以直接在IDE中Run As Java Application，然后选择Application.java
也可以直接用maven命令：mvn spring-boot:run

### 2.spring-boot-starter-actuator
添加适用于生产环境的功能，如性能指标和监测等功能。

	HTTP方法	路径				描述						鉴权
	GET		/autoconfig		查看自动配置的使用情况		true
	GET		/configprops	查看配置属性，包括默认配置	true
	GET		/beans			查看bean及其关系列表		true
	GET		/dump			打印线程栈					true
	GET		/env			查看所有环境变量			true
	GET		/env/{name}		查看具体变量值				true
	GET		/health			查看应用健康指标			false
	GET		/info			查看应用信息				false
	GET		/mappings		查看所有url映射			true
	GET		/metrics		查看应用基本指标			true
	GET		/metrics/{name}	查看具体指标				true
	POST	/shutdown		关闭应用					true
	GET		/trace			查看基本追踪信息			true

### 3.springfox
Springfox的前身是swagger-springmvc，是一个开源的API doc框架，可以将我们的Controller的方法以文档的形式展现。
访问地址：http://localhost:8080/swagger-ui.html
可以查看接口

### 4.spring-boot-starter-test
包含常用的测试所需的依赖，如 JUnit、Hamcrest、Mockito 和 spring-test 等。

### 5.logback
logback.xml为个人配置，不会提交
logback.xml.sample中配置日志按天输出，输出级别INFO

### 6.Druid + mybatis
Druid来自于阿里系的一个开源连接池，在连接池之外，还提供了非常优秀的监控功能。
MyBatis是一个支持普通SQL查询，存储过程和高级映射的优秀持久层框架。之所以选择MyBatis，是因为它采用的是原生SQL，能够更好的支持高级sql，比较简单容易上手。

### 7.shiro
Apache Shiro 是功能强大并且容易集成的开源权限框架，它能够完成认证、授权、加密、会话管理等功能。

