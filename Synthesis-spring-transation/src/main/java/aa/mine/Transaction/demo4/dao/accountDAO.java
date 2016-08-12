package aa.mine.Transaction.demo4.dao;


import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class accountDAO extends JdbcDaoSupport{
		
	public void outMoney(String out, Double money) {
		String sql = "update account set money = money-? where name = ?";
		this.getJdbcTemplate().update(sql, money, out);
	}

	
	public void inMoney(String in, Double money) {
		String sql = "update account set money = money+? where name = ?";
		this.getJdbcTemplate().update(sql, money, in);
	}
	
	
//	public account getOne(String name) {
//		String sql = "select * from account where name = ?";
////		this.getJdbcTemplate().update(sql , name);
//		account account = null;
//		//ResultSetExtractor rowMapper;
//		account = this.getJdbcTemplate().query(sql, name, account);
//		return account;
//	}
}
