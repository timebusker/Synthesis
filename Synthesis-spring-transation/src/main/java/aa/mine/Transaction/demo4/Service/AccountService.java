package aa.mine.Transaction.demo4.Service;

import org.springframework.transaction.annotation.Transactional;
import aa.mine.Transaction.demo4.dao.accountDAO;

@Transactional
public class AccountService {
	
	
	private accountDAO accountDAO;

	public void setAccountDAO(accountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public void transfer(String out, String in, Double money) {
		accountDAO.outMoney(out, money);
	    //int i = 1/0;
		accountDAO.inMoney(in, money);
	}
}
