package aa.mine.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import aa.mine.Entity.user;

@Controller
@RequestMapping("/user")
public class userConroller {

	@RequestMapping(value={"/", ""})
	private String mine() {		
		return "user/login_success";
	}
	
	@RequestMapping("/tologin")
	private String gologin() {
		return "user/login";
	}
	
	@RequestMapping("/login")
	private String login(HttpServletRequest request,@ModelAttribute user user,Model model) {
		System.out.println(user.toString());
		if(user.getUsername() != null &&
				user.getPassword() != null){
			//mv.addObject("user", user.getUsername());
			request.getSession().setAttribute("user", user.getUsername());
			model.addAttribute("user", user.getUsername());
			Cookie [] cookies = request.getCookies();
			String RequestURI = null;
			for (Cookie cookie : cookies) {
				if("RequestURI".equals(cookie.getName())){
					RequestURI=cookie.getValue();
					return "redirect:"+RequestURI;
				}					
			}
			return "login_success";
		}
		return "user/login_faile";
	}
}
