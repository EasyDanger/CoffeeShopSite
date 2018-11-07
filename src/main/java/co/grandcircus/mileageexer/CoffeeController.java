package co.grandcircus.mileageexer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeController {

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/traitor")
	public ModelAndView mileForm() {
		return new ModelAndView("traitor");
	}

	@RequestMapping("/verifyTraitor")
	public ModelAndView verifyTraitor(@RequestParam("firstName") String fName, @RequestParam("lastName") String lName, @RequestParam("email") String email, @RequestParam("phone") String phone, @RequestParam("passWord") String pWord, @RequestParam("passWord2") String pWord2) {
		ModelAndView mv = new ModelAndView("verifyTraitor");
		
		mv.addObject("firstName", fName);
		mv.addObject("lastName", lName);
		mv.addObject("email", email);
		mv.addObject("phone", phone);
		mv.addObject("passWord", pWord);
		return mv;
	
	}
	
	
	@RequestMapping("/addTraitor")
	public ModelAndView addTraitor(@RequestParam("firstName") String fName) {
		ModelAndView mv = new ModelAndView("addTraitor");
		mv.addObject("firstName", fName);
		return mv;
	}

	
}