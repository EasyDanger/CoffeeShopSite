package co.easydanger.coffeeShop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeController {

	@Autowired
	UserDao userDao;
	@Autowired
	MenuItemDao menuItemDao;

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
		userDao.create(user);
		mv.addObject("user", user);
		return mv;

	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping("/login2")
	public ModelAndView login2(@RequestParam("userName") String name, @RequestParam("passWord") String pWord) {
		ModelAndView mv = new ModelAndView("loginE");
		List<User> list = userDao.findAll();
		
		for (User user: list) {
			if (name.equals(user.getName()) && pWord.equals(user.getPword())) {
				mv = new ModelAndView("redirect:/menu");
				System.out.println("hello");
			}
		}
		return mv;
		}
	
	@RequestMapping("/menu")
	public ModelAndView menu() {

		List<MenuItem> list = new ArrayList<MenuItem>();
		list = menuItemDao.findAll();
		System.out.println("hello");
		System.out.println(list);
		ModelAndView mv = new ModelAndView("menu");
		mv.addObject("list", list);
		return mv;

	}
}