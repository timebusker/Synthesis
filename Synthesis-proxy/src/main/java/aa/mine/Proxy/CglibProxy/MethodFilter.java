package aa.mine.Proxy.CglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

/**
 * CGLIB过滤器
 * @author Administrator
 *
 */
public class MethodFilter implements CallbackFilter {

	public int accept(Method method) {
		// TODO Auto-generated method stub
		if("say".equalsIgnoreCase(method.getName()))
			return 0;
		else
			return 1;
	}

}
