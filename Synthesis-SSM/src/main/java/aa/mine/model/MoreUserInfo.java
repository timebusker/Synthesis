package aa.mine.model;

import java.util.Date;
import java.util.List;

public class MoreUserInfo {

	private Integer id;

	private String name;

	private String nick;

	private String password;

	private Date createdate;

	private Date updatedate;
	
	private List<UserRole> lisUserRole;

	public Integer getUserid() {
		return id;
	}

	public void setUserid(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public List<UserRole> getLisUserRole() {
		return lisUserRole;
	}

	public void setLisUserRole(List<UserRole> lisUserRole) {
		this.lisUserRole = lisUserRole;
	}
}
