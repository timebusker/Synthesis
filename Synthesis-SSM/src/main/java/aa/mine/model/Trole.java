package aa.mine.model;

public class Trole {
    private Integer id;

    private String roleName;

    private String allowableRes;

    private String unallowableRes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getAllowableRes() {
        return allowableRes;
    }

    public void setAllowableRes(String allowableRes) {
        this.allowableRes = allowableRes == null ? null : allowableRes.trim();
    }

    public String getUnallowableRes() {
        return unallowableRes;
    }

    public void setUnallowableRes(String unallowableRes) {
        this.unallowableRes = unallowableRes == null ? null : unallowableRes.trim();
    }
}