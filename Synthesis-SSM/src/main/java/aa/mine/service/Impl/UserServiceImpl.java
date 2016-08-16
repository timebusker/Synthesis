package aa.mine.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aa.mine.dao.MoreUserInfoMapper;
import aa.mine.dao.TuserMapper;
import aa.mine.model.MoreUserInfo;
import aa.mine.model.Tuser;
import aa.mine.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private TuserMapper userDao;
	
	@Autowired
	private MoreUserInfoMapper muiDao;
	
	@Override
	public Tuser getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tuser> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tuser> getAll2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tuser> getAll3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tuser getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(id);
	}

	@Override
	public int insert(Tuser record) {
		// TODO Auto-generated method stub
		return userDao.insert(record);
	}

	@Override
	public List<MoreUserInfo> getMUI() {
		// TODO Auto-generated method stub
		return muiDao.getALLMUI();
	}

	@Override
	public MoreUserInfo getMUI(Integer id) {
		// TODO Auto-generated method stub
		return muiDao.getMUI(id);
	}

}
