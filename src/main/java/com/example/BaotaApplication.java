package com.example;

import com.example.service.test.Hello;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class BaotaApplication {

	public static void main(String[] args) {

		/**
		 *第一步利用框架提供的 XmlBeanFactory() API 去生成工厂 bean 以及利用 ClassPathResource() API 去加载在路径 CLASSPATH 下可用的 bean 配置文件。
		 * XmlBeanFactory() API 负责创建并初始化所有的 对象，即在配置文件中提到的 bean
		 */
		/*XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		Hello hello = (Hello) xmlBeanFactory.getBean("hello");
		hello.sayHello();*/

		/*ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Hello bean = classPathXmlApplicationContext.getBean(Hello.class);
		bean.sayHello();*/

		SpringApplication.run(BaotaApplication.class, args);
	}
}
