package co.easydanger.coffeeShop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.easydanger.coffeeShop.dao.CartDao;
import co.easydanger.coffeeShop.dao.CustomerDao;
import co.easydanger.coffeeShop.dao.MenuItemDao;
import co.easydanger.coffeeShop.entity.Cart;
import co.easydanger.coffeeShop.entity.Customer;
import co.easydanger.coffeeShop.entity.MenuItem;

@Controller
public class CustomerPageController {

	@Autowired
	CustomerDao custDao;
	@Autowired
	MenuItemDao menuDao;
	@Autowired
	CartDao cartDao;

	@RequestMapping("/menuCustomer")
	public ModelAndView menu() {

		List<MenuItem> list = new ArrayList<MenuItem>();
		list = menuDao.findAll();
		System.out.println("hello, darling");
		ModelAndView mv = new ModelAndView("menuCust");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("/verifyCustomer")
	public ModelAndView verifyCust(@RequestParam("Name") String name, @RequestParam("firstName") String fName,
			@RequestParam("lastName") String lName, @RequestParam("email") String email,
			@RequestParam("cardNum") String cardNum, @RequestParam("pWord") String pWord,
			@RequestParam("passWord2") String pWord2, @RequestParam("box") boolean box) {
		ModelAndView mv = new ModelAndView("verifyCustomer");
		// Need to finish dealing with this box.
		mv.addObject("Name", name);
		mv.addObject("firstName", fName);
		mv.addObject("lastName", lName);
		mv.addObject("email", email);
		mv.addObject("cardNum", cardNum);
		mv.addObject("passWord", pWord);
		return mv;
	}

	@RequestMapping("/addcustomer")
	public ModelAndView addcust(@RequestParam("firstName") String fName, @RequestParam("Name") String name,
			@RequestParam("lastName") String lName, @RequestParam("email") String email,
			@RequestParam("cardNum") String cardNum, @RequestParam("passWord") String pWord) throws IOException {
		ModelAndView mv = new ModelAndView("addCustomer");
		Customer customer = new Customer();
		customer.setName(name);
		customer.setFname(fName);
		customer.setLname(lName);
		customer.setEmail(email);
		customer.setCardNum(cardNum);
		customer.setPword(pWord);
		custDao.create(customer);
		mv.addObject("customer", customer);
		return mv;

	}

	@RequestMapping("/menu/{Name}/cust")
	public ModelAndView menuNotAdmin(@PathVariable("Name") String name) {

		List<MenuItem> list = new ArrayList<MenuItem>();
		list = menuDao.findAll();
		ModelAndView mv = new ModelAndView("menuNonAdmin");
		mv.addObject("list", list);
		mv.addObject("Name", name);
		return mv;
	}
//	@RequestMapping("/addToCart/{item}")
//	public ModelAndView addToCart(@PathVariable("item") String item,
//			HttpSession session, RedirectAttributes redir) {
//		ModelAndView mv = new ModelAndView("menuCust");
//		System.out.println(item);
//		MenuItem mi = menuDao.findByName(item);
//		Customer cust = (Customer) session.getAttribute("Customer");
//		cust.cart.addToList(mi);
//		
//		session.setAttribute("cart", cust.cart);
//		return mv;
//		
//	}
	@RequestMapping("/addToCart/{item}")
	public ModelAndView addToCart(@PathVariable("item") String item,
			HttpSession session, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView("menuCust");
		MenuItem mi = menuDao.findByName(item);
		Customer cust = (Customer) session.getAttribute("Customer");
		List<Cart> carts = (List<Cart>) session.getAttribute("Cart");		
		boolean isThere = false;
		for (Cart cart: carts) {
			if ((mi.getId() == cart.getMenuId()) && (cart.getCust() == cust.getId())) {
				cart.addQuant();
				isThere = true;
			}
		}
		if (!isThere) {
			Cart cart = new Cart(mi.getId(), cust.getId());
			cartDao.create(cart);
			carts.add(cart);
		}
		session.setAttribute("Customer", cust);
		session.setAttribute("Cart", carts);
		return new ModelAndView("redirect:/menuCustomer");
	}
}
