package aa.mine.Proxy.CglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibTimerProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class clazz) {
		// 设置创建子类的类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		enhancer.setCallbackFilter(new MethodFilter());
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
		Object Object;
		if("getProxys".equals(m.getName())){
			Object = proxy.invokeSuper(obj, args);			
		}else{
			System.out.println("汽车开始行驶。。。");
			
			System.out.println("************************");
	    	System.out.println(obj.getClass().getName()+"__"+m.getName()+"__"+args.toString()+proxy.getClass().getName());
	    	System.out.println("************************");
			
			long start = System.currentTimeMillis();
			// 代理类调用父类的方法
			Object = proxy.invokeSuper(obj, args);
			long end = System.currentTimeMillis();
			System.out.println("汽车行驶结束。。。");
			System.out.println("汽车行驶时间为："+(end - start)+"ms");			
		}
		return Object;
	}
	
	public void say(){
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	}
}
