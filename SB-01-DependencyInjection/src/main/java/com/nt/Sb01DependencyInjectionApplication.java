package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

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
	public LocalDateTime createLocalDateTime1() {
		System.out.println("Sb01DependencyInjectionApplication.createLocalDateTime1()");
		return LocalDateTime.now();
	}// createLocalDateTime()

	public static void main(String[] args) {
		System.out.println("Sb01DependencyInjectionApplication.main(-)");
		ApplicationContext ctx = null;
		WishMessageGenerator wmg = null;
		String result = null;
		// access IOC container
		ctx = SpringApplication.run(Sb01DependencyInjectionApplication.class, args);
		// get target class object
		wmg = ctx.getBean("wmg", WishMessageGenerator.class);
		// invoke business method
		result = wmg.generateWishMsg("Sri Rama");
		// display the result
		System.out.println(result);
		// close IOC container
		((ConfigurableApplicationContext) ctx).close();
	}// main(-)

}// class
