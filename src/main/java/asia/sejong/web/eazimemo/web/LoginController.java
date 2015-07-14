package asia.sejong.web.eazimemo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import asia.sejong.web.eazimemo.service.ArticleService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	ArticleService articleService;
	
	final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password! " + error);
		}
 
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully. " + logout);
		}
		model.setViewName("login/loginPage");
 
		return model;
	}
}
