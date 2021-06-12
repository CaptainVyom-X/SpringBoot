package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.beans.Student;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class Sb03DiJavaConfigAnnotationsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Student student = null;
		// access IOC container
		ctx = SpringApplication.run(Sb03DiJavaConfigAnnotationsApplication.class, args);
		// get target bean class object from IOC container
		student = ctx.getBean("std", Student.class);
		// invoke business
		student.perpare("Infosys Interview");
		// close IOC container
		((ConfigurableApplicationContext) ctx).close();
	}// main(-)

}// class
