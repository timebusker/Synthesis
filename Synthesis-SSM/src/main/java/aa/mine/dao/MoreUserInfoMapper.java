package aa.mine.dao;

import java.util.List;
import aa.mine.model.MoreUserInfo;

public interface MoreUserInfoMapper {

	List<MoreUserInfo> getALLMUI();

	MoreUserInfo getMUI(Integer id);
	
}
