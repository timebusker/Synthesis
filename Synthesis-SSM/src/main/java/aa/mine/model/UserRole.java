package aa.mine.model;


public class UserRole {
	
	private Trole role;
	
    private Integer id;

    private Integer uesrId;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUesrId() {
        return uesrId;
    }

    public void setUesrId(Integer uesrId) {
        this.uesrId = uesrId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

	public Trole getRole() {
		return role;
	}

	public void setRole(Trole role) {
		this.role = role;
	}
    
}