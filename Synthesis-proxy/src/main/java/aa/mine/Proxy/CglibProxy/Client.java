package aa.mine.Proxy.CglibProxy;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		CglibLogerProxy logproxy = new CglibLogerProxy();
//		Train loger = (Train) logproxy.getProxy(Train.class);
//		loger.move();
//		
//		System.out.println();
//
//		CglibTimerProxy timeproxy = new CglibTimerProxy();
//		Train timer = (Train) timeproxy.getProxy(Train.class);
//		timer.move();
//		
//		System.out.println();

		CglibTimerProxy tproxy = new CglibTimerProxy();
		CglibLogerProxy lproxy = (CglibLogerProxy) tproxy.getProxy(CglibLogerProxy.class);
		Train sl = (Train) lproxy.getProxy(Train.class);
		sl.move();
	}
}
