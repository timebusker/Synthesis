package aa.mine.superutil.j2se;

/**
 * 操作系统判断
 * @author <a href="http://www.xdemo.org/">http://www.xdemo.org/</a>
 * 252878950@qq.com
 */
public class SystemUtils {
	
	private static final String osname=System.getProperty("os.name").toLowerCase();
	
	/**
	 * 判断是否是Linux系统
	 * @return Boolean
	 */
	public static boolean isLinux(){
		if(osname.indexOf("linux")>=0){
			return true;
		}
		return false;
	}
	/**
	 * 判断是否是Linux系统
	 * @return Boolean
	 */
	public static boolean isWindows(){
		if(osname.indexOf("windows")>=0){
			return true;
		}
		return false;
	}
	/**
	 * 判断是否是Linux系统
	 * @return Boolean
	 */
	public static boolean isMac(){
		if(osname.indexOf("mac")>=0){
			return true;
		}
		return false;
	}
	/**
	 * 返回系统名称
	 * @return String
	 */
	public static String getOSName(){
		return osname;
	}

}
