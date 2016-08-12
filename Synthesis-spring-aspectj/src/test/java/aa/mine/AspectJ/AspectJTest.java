package aa.mine.AspectJ;

import org.junit.Test;
import aa.mine.JUnitBase;
import aa.mine.AspectJ.DAO.UserDAO;


public class AspectJTest extends JUnitBase{

	public AspectJTest() {
		super("classpath:spring/SpringAspectJ.xml");
	}
	
	@Test
	public void test() {
		UserDAO dao = super.getBean("userDAO");
		dao.addUser("personName");
//		dao.delUser("personName");
//		dao.editUser("personName");
	}
}
