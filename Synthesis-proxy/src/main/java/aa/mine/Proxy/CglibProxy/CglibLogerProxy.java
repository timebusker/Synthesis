package aa.mine.Proxy.CglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class CglibLogerProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	public void say(){
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	}
	
	public Object getProxy(Class clazz) {
		this.say();
		// 设置创建子类的类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
//		enhancer.setCallbackFilter(new MethodFilter());
		return enhancer.create();
	}

	/**
	 * 拦截所有目标类方法的调用 
	 * Object 目标类的实例
	 * Method 目标方法的反射对象 
	 * Object[] 方法的参数 
	 * MethodProxy 代理类的实例
	 */

	public Object intercept(Object obj, Method m, Object[] args, MethodProxy proxy) throws Throwable {
    	System.out.println("日志开始...");
    	System.out.println("************************");
    	System.out.println(obj.getClass().getName()+"__"+m.getName()+"__"+args.toString()+proxy.getClass().getName());
    	System.out.println("************************");
		// 代理类调用父类的方法
		Object Object = proxy.invokeSuper(obj, args);
		System.out.println("日志结束...");
		return Object;
	}		
}
