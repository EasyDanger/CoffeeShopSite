package co.easydanger.coffeeShop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerPageController {

	@Autowired
	UserDao userDao;
	@Autowired
	MenuItemDao menuItemDao;

	@RequestMapping("/menu/customer")
	public ModelAndView menu() {

		List<MenuItem> list = new ArrayList<MenuItem>();
		list = menuItemDao.findAll();
		ModelAndView mv = new ModelAndView("menuCust");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/login/customer")
	public ModelAndView customer() {
		return new ModelAndView("cLogin");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/menu/{Name}/cust")
	public ModelAndView menuNotAdmin(@PathVariable("Name") String name) {

		List<MenuItem> list = new ArrayList<MenuItem>();
		list = menuItemDao.findAll();
		ModelAndView mv = new ModelAndView("menuNonAdmin");
		mv.addObject("list", list);
		mv.addObject("Name", name);
		return mv;
	}
}
