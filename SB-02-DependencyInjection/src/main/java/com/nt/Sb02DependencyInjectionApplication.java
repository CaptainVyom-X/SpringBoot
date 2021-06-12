package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.beans.Student;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class Sb02DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Student std = null;
		// access IOC container
		ctx = SpringApplication.run(Sb02DependencyInjectionApplication.class, args);
		// get target bean class object from IOC container
		std = ctx.getBean("std", Student.class);
		// invoke business
		std.perpare("Infosys Interview");
	}// main(-)

}// class
