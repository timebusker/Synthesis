package com.mine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mine.service.UseDataService;

public class consumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = null;
		try {
			 context = 
					new ClassPathXmlApplicationContext("config/spring-context.xml");
		} catch (Exception e) {
			// TODO: handle exception
		}
		UseDataService UseDataService = null;
		try {
			UseDataService = (UseDataService)context.getBean("useDataService");
		} catch (Exception e) {
			// TODO: handle exception
		}		
		UseDataService.add("timebusker");
	}	
}
