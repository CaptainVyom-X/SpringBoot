package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.CoronaPatientVO;

@SpringBootApplication
public class Sb04LAutoCfgRtDiStrategyDpCoronaPatientsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Scanner sc = null;
		int citiesCount = 0;
		String[] cities = null;
		MainController controller = null;
		List<CoronaPatientVO> listVO = null;
		// access IOC container
		ctx = SpringApplication.run(Sb04LAutoCfgRtDiStrategyDpCoronaPatientsApplication.class, args);
		if (ctx != null) {
			// create Scanner object
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter No. of cities : ");
				citiesCount = sc.nextInt();
				// create array and add elements to it
				cities = new String[citiesCount];
				for (int i = 0; i < citiesCount; i++) {
					System.out.println("Enter the city name : ");
					cities[i] = sc.next();
				} // for
					// get Controller class object
				controller = ctx.getBean("controller", MainController.class);
				if (controller != null) {
					try {
						// invoke business method
						listVO = controller.collectCoronaPatientsData(cities);
						if (listVO != null) {
							// display the results
							for (CoronaPatientVO vo : listVO) {
								System.out.println(vo.getPatientId() + " " + vo.getPatientName() + " " + vo.getAge()
										+ " " + vo.getGender() + " " + vo.getContactNo() + " " + vo.getCity() + " "
										+ vo.getStatus());
							} // for
						} // if -> listVO
					} catch (Exception e) {
						e.printStackTrace();
						// e.getMessage();
					} finally {
						// close Scanner object
						sc.close();
						// close IOC container
						((ConfigurableApplicationContext) ctx).close();
					} // finally
				} // if -> controller
			} // if -> sc
		} // if -> ctx
	}// main(-)

}
