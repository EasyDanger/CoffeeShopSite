package co.easydanger.coffeeShop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.easydanger.coffeeShop.dao.MenuItemDao;
import co.easydanger.coffeeShop.dao.UserDao;
import co.easydanger.coffeeShop.entity.MenuItem;
import co.easydanger.coffeeShop.entity.User;

@Controller
public class CoffeeController {

	@Autowired
	UserDao userDao;
	@Autowired
	MenuItemDao menuItemDao;

	@RequestMapping("/")
	public ModelAndView index(HttpSession session, RedirectAttributes redir) throws IOException {
		return new ModelAndView("index");
	}

	@RequestMapping("/menu")
	public ModelAndView menu(HttpSession session, RedirectAttributes redir) {
		List<MenuItem> list = new ArrayList<MenuItem>();
		list = menuItemDao.findAll();
		ModelAndView mv = new ModelAndView("menu");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("/removeMenu/{OldItem}")
	public ModelAndView deleteMenu(@PathVariable("OldItem") String oldItem) {
		MenuItem oItem = menuItemDao.findByName(oldItem);
		Long x = oItem.getId();
		menuItemDao.delete(x);
		return new ModelAndView("redirect:/menu/");
	}

	@RequestMapping("/members/{Name}")
	public ModelAndView membs(@PathVariable("Name") String name) {
		List<User> list = new ArrayList<User>();
		list = userDao.findAll();
		ModelAndView mv = new ModelAndView("membersNon", "Name", name);
		if (userDao.findByName(name).isAdmin()) {
			mv = new ModelAndView("members", "Name", name);
		}
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("/member/toggle/{Name}/update/{newName}")
	public ModelAndView toggleAdmin(@PathVariable("Name") String name, @PathVariable("newName") String newName) {
		User nuser = userDao.findByName(newName);
		nuser.toggleAdmin();
		userDao.update(nuser);
		System.out.println(nuser);
		return new ModelAndView("redirect:/members/" + name);
	}

	@RequestMapping("/member/delete/{Name}/update/{newName}")
	public ModelAndView deleteUser(@PathVariable("Name") String name, @PathVariable("newName") String newName) {
		User nuser = userDao.findByName(newName);
		Long x = nuser.getId();
		userDao.delete(x);
		return new ModelAndView("redirect:/members/" + name);
	}

	@RequestMapping("/ill")
	public ModelAndView ill(HttpSession session, RedirectAttributes redir) {
		return new ModelAndView("illusionOfChoice");
	}

	@RequestMapping("/addItem")
	public ModelAndView additem() {
		ModelAndView mv = new ModelAndView("addItem");
		return mv;
	}

	@PostMapping("/menuAdd")
	public ModelAndView menuAdd(@RequestParam("itemName") String item,
			@RequestParam("Price") Double price, @RequestParam("Description") String desc, HttpSession session, RedirectAttributes redir) {

		MenuItem mi = new MenuItem(item, price, desc);
		menuItemDao.create(mi);
		redir.addFlashAttribute("message", "Your item has been added.");
		return new ModelAndView("redirect:/menu");
	}
}