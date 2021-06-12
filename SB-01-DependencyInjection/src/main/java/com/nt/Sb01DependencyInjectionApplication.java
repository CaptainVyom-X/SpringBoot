package com.nt;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class Sb01DependencyInjectionApplication {

	public Sb01DependencyInjectionApplication() {
		System.out.println("Sb01DependencyInjectionApplication : 0-param constructor");
	}// constructor

	@Bean
	@Primary
	public LocalDateTime createLocalDateTime() {
		System.out.println("Sb01DependencyInjectionApplication.createLocalDateTime()");
		return LocalDateTime.now();
	}// createLocalDateTime()

	@Bean(name = "ldt1")
	@Scope(value = "prototype")
	public LocalDateTime createLocalDateTime1() {
		System.out.println("Sb01DependencyInjectionApplication.createLocalDateTime1()");
		return LocalDateTime.now();
	}// createLocalDateTime()

	public static void main(String[] args) {
		System.out.println("Sb01DependencyInjectionApplication.main(-)");
		ApplicationContext ctx = null;
		WishMessageGenerator wmg1 = null;
		WishMessageGenerator wmg2 = null;
		String result = null;
		// access IOC container
		ctx = SpringApplication.run(Sb01DependencyInjectionApplication.class, args);
		// get ConfigurationCumClientApplication bean class name
		Sb01DependencyInjectionApplication bean1 = ctx.getBean("sb01DependencyInjectionApplication",
				Sb01DependencyInjectionApplication.class);
		System.out.println(bean1.getClass() + " <-> " + bean1.hashCode());
		System.out.println("-------------------------------------------------");
		// get LocalDateTime bean class name
		LocalDateTime bean2 = ctx.getBean("ldt1", LocalDateTime.class);
		System.out.println(bean2.getClass() + " <-> " + bean2.hashCode());
		System.out.println("-------------------------------------------------");
		System.out.println("All Beans' IDs : " + Arrays.toString(ctx.getBeanDefinitionNames()));
		System.out.println("Beans Count : " + ctx.getBeanDefinitionCount());
		System.out.println("-------------------------------------------------");
		// get target class object from IOC container
		wmg1 = ctx.getBean("wmg", WishMessageGenerator.class);
		// invoke business method
		result = wmg1.generateWishMsg("Sri Rama");
		// display the result
		System.out.println(result);
		wmg2 = ctx.getBean("wmg", WishMessageGenerator.class);
		System.out.println(wmg1.hashCode() + " <-> " + wmg2.hashCode());
		System.out.println("Is wmg1 == wmg2 ? " + (wmg1 == wmg2));
		// close IOC container
		((ConfigurableApplicationContext) ctx).close();
	}// main(-)

}// class
