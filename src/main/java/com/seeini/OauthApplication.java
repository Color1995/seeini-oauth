package com.seeini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@ServletComponentScan
@SpringBootApplication
public class OauthApplication {


	public static void main(String[] args) {
		SpringApplication.run(OauthApplication.class, args);
//		ApplicationContext applicationContext =
//				SpringApplication.run(StackApplication.class, args);
//		for (String name : applicationContext.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
	}

	// war包 实现方法
	public static class ServletInitializer extends SpringBootServletInitializer {

		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(OauthApplication.class);
		}

	}

}
