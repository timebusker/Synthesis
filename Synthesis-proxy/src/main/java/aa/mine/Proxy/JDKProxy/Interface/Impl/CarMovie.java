package aa.mine.Proxy.JDKProxy.Interface.Impl;

import aa.mine.Proxy.JDKProxy.Interface.Moiveable;

public class CarMovie implements Moiveable{

	public void movie() {
		try {			
			Thread.sleep(1000);
			System.out.println("汽车行驶中。。。。");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
