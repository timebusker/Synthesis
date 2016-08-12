package aa.mine.mybatis.demo1.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import aa.mine.mybatis.demo1.entity.User;


public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	public User findUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = this.getSqlSession();
		User user = sqlSession.selectOne("uesr.findUserById", id);

		return user;
	}

}
