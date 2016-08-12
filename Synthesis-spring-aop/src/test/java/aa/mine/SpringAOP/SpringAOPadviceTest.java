package aa.mine.SpringAOP;

import org.junit.Test;
import aa.mine.JUnitBase;
import aa.mine.springaop.advice.DAO.PresionDAO;
import aa.mine.springaop.advice.DAO.UserDAO;

public class SpringAOPadviceTest extends JUnitBase{

	public SpringAOPadviceTest() {
		super("classpath:spring/SpringAOP-advice.xml");
	}
	
	@Test
	public void test() {
		UserDAO dao = super.getBean("userDAO");
		dao.biz();
		System.out.println();
		PresionDAO PresionDAO = super.getBean("presionDAO");
		PresionDAO.addUser("aaaaa");
	}
}