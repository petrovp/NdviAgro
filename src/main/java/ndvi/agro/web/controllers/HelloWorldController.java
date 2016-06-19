package ndvi.agro.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ndvi.agro.persistance.datamodel.User;
import ndvi.agro.persistance.repostories.UserRepository;
 
@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	String message = "Welcome to Spring MVC!";

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
}