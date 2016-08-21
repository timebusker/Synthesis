package aa.mine.Interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class userInterceptor implements HandlerInterceptor {

	/**
	 * Object 表示被拦截的请求的目标对象
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse respone, Object obj, Exception arg3)
			throws Exception {
	}

	/**
	 * Object 表示被拦截的请求的目标对象 可以通过 ModelAndView 来改变显示的视图或修改发往视图的方法
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse respone, Object obj, ModelAndView mv)
			throws Exception {

	}

	/**
	 * Object 表示被拦截的请求的目标对象 返回值表示是否需要将当前的请求拦截下来 返回值为 false 当前请求将被终止 返回值为 true
	 * 当前请求将被继续执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		System.out.println("\n---------------------------------------------\n");
		System.out.println(obj.toString());
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestedSessionId());
		System.out.println("http://" + request.getServerName() + ":" + request.getServerPort());
		System.out.println("\n---------------------------------------------\n");
		HttpSession session = request.getSession();
		/*boolean isnew = session.isNew();
		if (isnew) {
			request.getSession().invalidate();
			request.getSession().setAttribute("KISSO-" + System.currentTimeMillis(), true);
		}*/
		
		request.getSession().invalidate();
		request.getSession().setAttribute("KISSO-" + System.currentTimeMillis(), true);
		
		System.out.println("\n"+request.getRequestedSessionId()+"\n");
		
		Cookie cookie = new Cookie("RequestURI", "http://" + request.getServerName() + ":" + request.getServerPort()+request.getRequestURI());
		cookie.setPath("/");
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		String user = (String) request.getSession().getAttribute("user");
		if (user != null) {
			return true;
		} else {
			// request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request,
			// response);
			response.sendRedirect(request.getContextPath() + "/user/tologin");
			return true;
		}
	}

}
