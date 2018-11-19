package co.easydanger.coffeeShop;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.easydanger.coffeeShop.dao.CartDao;
import co.easydanger.coffeeShop.dao.UserDao;
import co.easydanger.coffeeShop.entity.User;

@Controller
public class AuthController {

	@Autowired
	UserDao userDao;
	@Autowired
	CartDao cartDao;

	@RequestMapping("/login")
	public ModelAndView login(HttpSession session, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@PostMapping("/login")
	// get the username and password from the form when it's submitted.
	public ModelAndView submitLogin(@RequestParam("userName") String name, @RequestParam("passWord") String pWord,
			HttpSession session, RedirectAttributes redir) {
		// Find the matching user.
		User user = userDao.findByName(name);
		if (user == null || !pWord.equals(user.getPword())) {
			// If the user or password don't match, display an error message.
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("message", "We're sorry. That combination has not been prepped for processing.");
			return mav;
		}

		// On successful login, add the user to the session.
		session.setAttribute("User", user);
		// A flash message will only show on the very next page. Then it will go away.
		// It is useful with redirects since you can't add attributes to the mav.
		redir.addFlashAttribute("message", "Welcome, " + user.getName());
		return new ModelAndView("redirect:/ill");
	}
//
//	@RequestMapping("/logout")
//	public ModelAndView logout(HttpSession session, RedirectAttributes redir) {
//		// invalidate clears the current user session and starts a new one.
//		session.invalidate();
//
//		// A flash message will only show on the very next page. Then it will go away.
//		// It is useful with redirects since you can't add attributes to the mav.
//		redir.addFlashAttribute("message", "We will see you next time. Next time.");
//		return new ModelAndView("redirect:/");
//	}

	@RequestMapping("/traitor")
	public ModelAndView signup() {
		return new ModelAndView("traitor");
	}

	@PostMapping("/verifyTraitor")
	public ModelAndView submitSignupForm(@RequestParam("passWord2") String confirmPassword,
			@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("email") String email, @RequestParam("phone") String phone, @RequestParam("Name") String name,
			@RequestParam("passWord") String pWord, @RequestParam("box") boolean box, HttpSession session,
			RedirectAttributes redir) {

		User user = new User();
		user.setName(name);
		user.setFname(firstName);
		user.setLname(lastName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPword(pWord);
		// Find the matching user.
		// Customer existingUser = custDao.findByName(cust.getName());
		List<User> custList = userDao.findAll();
		Boolean existingUser = false;
		for (User usah : custList) {
			if (usah.getName().equalsIgnoreCase(user.getName())) {
				existingUser = true;
			}
		}
		if (existingUser) {
			// If user already exists, display an error message.
			return new ModelAndView("signupCustomer", "message",
					"We're sorry. We've already taken someone with that username.");
		}

		if (!confirmPassword.equals(user.getPword())) {
			// If the user or passwords don't match, display an error message.
			return new ModelAndView("signupCustomer", "message", "Please ensure that your passwords match.");
		}
		ModelAndView mv = new ModelAndView("verifyTraitor");
		mv.addObject("Name", name);
		mv.addObject("firstName", firstName);
		mv.addObject("lastName", lastName);
		mv.addObject("email", email);
		mv.addObject("phone", phone);
		mv.addObject("passWord", pWord);
		return mv;
	}

	@RequestMapping("/addTraitor")
	public ModelAndView addCustomer(@RequestParam("firstName") String fName, @RequestParam("Name") String name,
			@RequestParam("lastName") String lName, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("passWord") String pWord, HttpSession session,
			RedirectAttributes redir) throws IOException {
		User user = new User();
		user.setName(name);
		user.setFname(fName);
		user.setLname(lName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPword(pWord);
		userDao.create(user);
		// On successful sign-up, add the user to the session.
		session.setAttribute("Customer", user);
		// A flash message will only show on the very next page. Then it will go away.
		// It is useful with redirects since you can't add attributes to the mav.
		redir.addFlashAttribute("message", "Thanks for signing up!");
		return new ModelAndView("redirect:/ill");
	}
//
//	@RequestMapping("/fixProfile")
//	public ModelAndView profile(HttpSession session, RedirectAttributes redir) {
//		ModelAndView mv = new ModelAndView("fixProfile");
//		return mv;
//	}
//
//	@PostMapping("/fixProfile")
//	public ModelAndView profile2(@RequestParam("firstName") String fName, @RequestParam("Name") String name,
//			@RequestParam("lastName") String lName, @RequestParam("email") String email,
//			@RequestParam("cardNum") String cardNum, @RequestParam("passWord") String pWord,
//			@RequestParam(value = "newWord", required = false) String newWord, HttpSession session,
//			RedirectAttributes redir) {
//;
//		Customer cust = (Customer) session.getAttribute("Customer");
//		if (pWord.equals(cust.getpWord()) && !newWord.equals("")) {
//			cust.setName(name);
//			cust.setFname(fName);
//			cust.setLname(lName);
//			cust.setEmail(email);
//			cust.setCardNum(cardNum);
//			cust.setPword(newWord);	
//			redir.addFlashAttribute("message", "Thank you for updating all of your precious into.");
//
//		} else if (pWord.equals(cust.getpWord())) {
//			cust.setName(name);
//			cust.setFname(fName);
//			cust.setLname(lName);
//			cust.setEmail(email);
//			cust.setCardNum(cardNum);
//			redir.addFlashAttribute("message", "Thank you for updating your info.");
//		} else {
//			redir.addFlashAttribute("message", "Check your password.");
//		}
//		userDao.update(cust);
//		session.setAttribute("Customer", cust);
//		return new ModelAndView("redirect:/fixProfile");
//	}

}
