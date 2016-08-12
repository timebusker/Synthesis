package aa.mine.mybatis.demo1.mapper;

import aa.mine.mybatis.demo1.entity.User;


public interface UserMapper {
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;

}
