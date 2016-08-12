package aa.mine.Proxy.JDKProxy;

import aa.mine.Proxy.JDKProxy.Interface.Moiveable;

public class movieTimerProxy  implements Moiveable{

	private Moiveable Moiveable;
		
	public movieTimerProxy(Moiveable Moiveable) {
		super();
		this.Moiveable = Moiveable;
	}

	public void movie() {
		System.out.println("汽车开始行驶。。。");
		long start = System.currentTimeMillis();
		Moiveable.movie();
		long end = System.currentTimeMillis();
		System.out.println("汽车行驶结束。。。");
		System.out.println("汽车行驶时间为："+(end - start)+"ms");
	}

	
}
