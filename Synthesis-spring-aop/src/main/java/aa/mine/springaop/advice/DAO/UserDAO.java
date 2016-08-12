package aa.mine.springaop.advice.DAO;


public class UserDAO {

	public void addUser(String personName) {
		System.out.println("add person  :" + personName);
	}

	public boolean delUser(String personName) {
		System.out.println("delete person  :" + personName);
		return true;
	}

	public void editUser(String personName) {
		System.out.println("edit person  :" + personName);
		throw new RuntimeException("edit person throw exception");
	}
	
	
	public void biz() {
		System.out.println("AspectBiz biz.");
//		throw new RuntimeException();
	}
	
	public void init(String bizName, int times) {
		System.out.println("AspectBiz init : " + bizName + "   " + times);
	}
}