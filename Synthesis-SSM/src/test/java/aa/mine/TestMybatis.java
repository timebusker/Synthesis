package aa.mine;

import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import aa.mine.model.MoreUserInfo;
import aa.mine.model.Tuser;
import aa.mine.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestMybatis {

	private static final Logger logger = Logger.getLogger(TestMybatis.class);

	@Autowired
	private UserService userService;

	@Test
	public void test1() {
		Tuser u = userService.getUserById(1);          //设置对象中包含日期的时间格式
		logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test2() {
		List<Tuser> l = userService.getAll();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test3() {
		List<Tuser> l = userService.getAll2();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test4() {
		List<Tuser> l = userService.getAll3();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}
	

	@Test
	public void test5() {
		Tuser u = new Tuser();          
		u.setName("name");
		u.setNick("nick");
		u.setPassword("password");
		u.setUpdatedate(new Date());
		u.setCreatedate(new Date());
		userService.insert(u);
	}
	
	@Test
	public void test6() {
		MoreUserInfo MUI = userService.getMUI(1);
		logger.info(JSON.toJSONStringWithDateFormat(MUI, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test7() {
		List<MoreUserInfo> MUI = userService.getMUI();
		logger.info(JSON.toJSONStringWithDateFormat(MUI, "yyyy-MM-dd HH:mm:ss"));
	}
}
