package aa.mine.Proxy.JDKProxy;

import aa.mine.Proxy.JDKProxy.Interface.Moiveable;

public class movieLogerProxy  implements Moiveable{

	private Moiveable Moiveable;
		
	public movieLogerProxy(Moiveable Moiveable) {
		super();
		this.Moiveable = Moiveable;
	}

	public void movie() {
		System.out.println("汽车行驶日志。。。开始");
		Moiveable.movie();
		System.out.println("汽车行驶日志。。。结束");
	}

	
}
