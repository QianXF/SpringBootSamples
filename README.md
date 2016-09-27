# SpringBootSamples
spring-boot示例工程，包含了spring-boot的基本功能

1.spring-boot-starter-web
支持 Web 应用开发，包含 Tomcat 和 spring-mvc。
可以直接在IDE中Run As Java Application，然后选择Application.java
也可以直接用maven命令：mvn spring-boot:run

2.spring-boot-starter-actuator
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

3.springfox
Springfox的前身是swagger-springmvc，是一个开源的API doc框架，可以将我们的Controller的方法以文档的形式展现。
访问地址：http://localhost:8080/swagger-ui.html
可以查看接口

4.spring-boot-starter-test
包含常用的测试所需的依赖，如 JUnit、Hamcrest、Mockito 和 spring-test 等。

5.logback
将src/main/resources/logback.xml.sample文件复制到该目录下命名为logback.xml
logback.xml为个人配置，不会提交
logback.xml.sample中配置日志按天输出，输出级别INFO
