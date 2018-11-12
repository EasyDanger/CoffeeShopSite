package co.easydanger.coffeeShop;

import java.io.IOException;

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
	public ModelAndView verifyTraitor(@RequestParam("Name") String name, @RequestParam("firstName") String fName,
			@RequestParam("lastName") String lName, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("passWord") String pWord,
			@RequestParam("passWord2") String pWord2, @RequestParam("box") boolean box) throws IOException {
		ModelAndView mv = new ModelAndView("verifyTraitor");
		// Need to finish dealing with this box.
		mv.addObject("Name", name);
		mv.addObject("firstName", fName);
		mv.addObject("lastName", lName);
		mv.addObject("email", email);
		mv.addObject("phone", phone);
		mv.addObject("passWord", pWord);

		return mv;
	}

	@RequestMapping("/addTraitor")
	public ModelAndView addTraitor(@RequestParam("firstName") String fName, @RequestParam("Name") String name,
			@RequestParam("lastName") String lName, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("passWord") String pWord) throws IOException {
		ModelAndView mv = new ModelAndView("addTraitor");
		User user = new User(name, fName, lName, email, phone, pWord);
		UserFile.writeApp(user);
		mv.addObject("user", user);
		return mv;

	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		
		return mv;

	}
	
	@RequestMapping("/menu")
	public ModelAndView menu() {
		return null;

	}
}