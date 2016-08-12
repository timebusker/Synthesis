package aa.mine.Proxy;

import aa.mine.Proxy.JDKProxy.movieLogerProxy;
import aa.mine.Proxy.JDKProxy.movieTimerProxy;
import aa.mine.Proxy.JDKProxy.Interface.Moiveable;
import aa.mine.Proxy.JDKProxy.Interface.Impl.CarMovie;

public class Client {

	public static void main(String[] args) {
		
		CarMovie Car = new CarMovie();
		
		Moiveable Moiveable = new movieTimerProxy(Car);
		movieTimerProxy mtp = new movieTimerProxy(Car);
		movieLogerProxy mlp = new movieLogerProxy(mtp);
		mlp.movie();
	}
}
