package aa.mine.Autowiring;

import org.junit.Test;
import aa.mine.JUnitBase;
import aa.mine.Autowiring.service.BeanAutowiringService;

public class BeanAutowiringTest extends JUnitBase {
	
	public BeanAutowiringTest() {
		super("classpath:spring/BeanAutowiring.xml");
	}

	@Test
	public void test(){
		BeanAutowiringService service = super.getBean("beanAutowiringService");
		String res = service.getOne("MINE");
		System.out.println(res);
	}
}
