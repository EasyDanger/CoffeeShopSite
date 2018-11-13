package co.easydanger.coffeeShop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
				mv = new ModelAndView("redirect:/ill/"+ name);
				System.out.println("hello");
			}
		}
		return mv;
		}
	
	@RequestMapping("/menu/{Name}")
	public ModelAndView menu(@PathVariable("Name") String name) {

		List<MenuItem> list = new ArrayList<MenuItem>();
		list = menuItemDao.findAll();
		System.out.println("hello");
		System.out.println(list);
		ModelAndView mv = new ModelAndView("menu");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/members/{Name}")
	public ModelAndView membs(@PathVariable("Name") String name) {

		List<User> list = new ArrayList<User>();
		list = userDao.findAll();
		System.out.println("hello");
		System.out.println(list);
		ModelAndView mv = new ModelAndView("members", "Name", name);
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("/ill/{name}")
	public ModelAndView ill(@PathVariable("name") String name) {
		return new ModelAndView("illusionOfChoice", "Name", name);
	}
	
	@RequestMapping("/addItem/{Name}")
	public ModelAndView additem(@PathVariable("Name") String name) {
		ModelAndView mv = new ModelAndView("addItem");
		return mv;
	}
	
	@PostMapping("/menuAdd/{Name}")
	public ModelAndView menuAdd(@PathVariable("Name") String name, @RequestParam("itemName") String item, @RequestParam("Price") Double price, @RequestParam("Description") String desc) {
		System.out.println(name + " " + item + " " + price + " " + desc);
		MenuItem mi = new MenuItem(item, price, desc);
		menuItemDao.create(mi);
		List<MenuItem> list = new ArrayList<MenuItem>();
		list = menuItemDao.findAll();
		System.out.println("helloall");
		System.out.println(list);
		ModelAndView mv = new ModelAndView("menu");
		mv.addObject("list", list);
		return mv;
	}
}