package aa.mine.Autowiring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aa.mine.Autowiring.dao.BeanAutowiringDAO;

@Service
public class BeanAutowiringService {
	
	public BeanAutowiringService() {
		// TODO Auto-generated constructor stub
		//System.out.println("BeanAutowiringService");
	}		
//  设置bean的自动装配后，采用setter或者constructor完成对象的装配	
//	private BeanAutowiringDAO beanAutowiringDAO;		
//	public void setBeanAutowiringDAO(BeanAutowiringDAO beanAutowiringDAO) {
//		this.beanAutowiringDAO = beanAutowiringDAO;
//	}
	
	@Autowired
	private BeanAutowiringDAO beanAutowiringDAO;
	
	public String getOne(String Id){
		System.out.println(beanAutowiringDAO.hashCode());
		return beanAutowiringDAO.getOne(Id);
	}
}
