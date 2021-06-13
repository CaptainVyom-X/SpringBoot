package com.nt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

@SpringBootApplication
public class Sb05LAutoCfgRtDiStrategyDpEmployeesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Scanner sc = null;
		int desgsCount = 0;
		String[] desgs = null;
		MainController controller = null;
		List<EmployeeVO> listVO = null;
		// access IOC container
		ctx = SpringApplication.run(Sb05LAutoCfgRtDiStrategyDpEmployeesApplication.class, args);
		// create Scanner object
		sc = new Scanner(System.in);
		// read inputs from end-user
		System.out.println("Enter Designations Count : ");
		desgsCount = sc.nextInt();
		if (desgsCount < 1) {
			System.out.println("Invalid Designations Count!");
			// System.exit(0);
			return;
		} // if
			// create array of String type
		desgs = new String[desgsCount];
		for (int i = 0; i < desgsCount; i++) {
			System.out.println("Enter Designation-" + (i + 1) + " : ");
			desgs[i] = sc.next();
		} // for
			// get Controller object
		controller = ctx.getBean("controller", MainController.class);
		try {
			// invoke business method
			listVO = controller.displayEmpsByDesgs(desgs);
			if (!listVO.isEmpty()) {
				// display the results
				System.out.println("List of Employees' Details for Designations " + Arrays.toString(desgs));
				listVO.forEach(vo -> System.out.println(vo));
			} else
				System.out.println("Invalid Designations " + Arrays.toString(desgs));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem! " + e.getMessage());
		} finally {
			// close Scanner object
			sc.close();
			// close IOC container
			((ConfigurableApplicationContext) ctx).close();
		} // finally
	}// main(-)

}
