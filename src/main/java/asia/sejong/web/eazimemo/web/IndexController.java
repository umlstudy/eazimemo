package asia.sejong.web.eazimemo.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

//	@RequestMapping("/index")
//	public String index() {
//		return "index";
//	}
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "스프링시큐리티 사용자로그인 폼 테스트");
		model.addObject("message", "환영하무니다.");
		model.setViewName("hello");
		return model;
 
	}
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "스프링시큐리티 사용자로그인 폼 테스트");
		model.addObject("message", "관리자 접근용 페이지무니다.");
		model.setViewName("admin/admin");
 
		return model;
 
	}
	
	@RequestMapping(value = "/page/**", method = RequestMethod.GET)
	public String page(HttpServletRequest request) {

		String view = request.getRequestURI();
		String ctx = request.getContextPath();
		String url = view.substring(ctx.length() + "/page".length(), view.length());

		return url;
	}
}
