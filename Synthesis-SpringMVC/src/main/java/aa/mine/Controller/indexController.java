package aa.mine.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

	@RequestMapping("/")
	private String index() {
		return "index";
	}
	
	@RequestMapping("/index")
	private String index1() {
		return "index";
	}
}
