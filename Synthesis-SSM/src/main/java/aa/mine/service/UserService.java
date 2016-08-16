package aa.mine.service;

import java.util.List;
import aa.mine.model.MoreUserInfo;
import aa.mine.model.Tuser;

public interface UserService {
	
	Tuser getUserById(String id);

	List<Tuser> getAll();

	List<Tuser> getAll2();

	List<Tuser> getAll3();

	Tuser getUserById(Integer id);
	
	int insert(Tuser record);
	
	List<MoreUserInfo> getMUI();
	
	MoreUserInfo getMUI(Integer id);

}
