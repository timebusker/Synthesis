package aa.mine.Autowiring.dao;

import org.springframework.stereotype.Repository;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@Repository
public class BeanAutowiringDAO {
	
	public BeanAutowiringDAO() {
		// TODO Auto-generated constructor stub
		//System.out.println("BeanAutowiringDAO");
	}

	public String getOne(String Id){		
		return Base64.encode(Id.getBytes());
	}
}
