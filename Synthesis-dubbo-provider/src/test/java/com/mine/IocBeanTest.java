package com.mine;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.base.UnitTestBase;
import com.mine.Impl.DataServiceImpl;
import com.mine.facde.DataService;

public class IocBeanTest extends UnitTestBase{

	public IocBeanTest() {
		super("classpath:/config/spring-context.xml");
	}
	
	@Test
	public void test() {
		DataServiceImpl service = super.getBean("dataServiceImpl");
		service.add();
	}
	
	@Test
	public void getIocbean() {
		ApplicationContext context = null;
		try {
			 context = 
					new ClassPathXmlApplicationContext("config/spring-context.xml");
		} catch (Exception e) {
			// TODO: handle exception
		}
		DataService service = null;
		try {
			service = (DataServiceImpl)context.getBean("dataServiceImpl");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(service.add());;
	}
}
