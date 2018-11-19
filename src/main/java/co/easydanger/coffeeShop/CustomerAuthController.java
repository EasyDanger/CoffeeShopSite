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
import co.easydanger.coffeeShop.dao.CustomerDao;
import co.easydanger.coffeeShop.entity.Cart;
import co.easydanger.coffeeShop.entity.Customer;
import co.easydanger.coffeeShop.github.GithubService;

@Controller
public class CustomerAuthController {

	@Autowired
	CustomerDao custDao;
	@Autowired
	GithubService githubService;
	@Autowired
	CartDao cartDao;

	@RequestMapping("/loginCustomer")
	public ModelAndView showLoginForm() {
		return new ModelAndView("loginCust");
	}

	@PostMapping("/loginCustomer")
	// get the username and password from the form when it's submitted.
	public ModelAndView submitLoginForm(@RequestParam("Name") String name, @RequestParam("passWord") String pWord,
			HttpSession session, RedirectAttributes redir) {
		// Find the matching user.
		Customer cust = custDao.findByName(name);
		if (cust == null || !pWord.equals(cust.getPword())) {
			// If the user or password don't match, display an error message.
			ModelAndView mav = new ModelAndView("loginCust");
			mav.addObject("message", "We're sorry. That combination has not been prepped for processing.");
			return mav;
		}

		List<Cart> carts = cartDao.findByCust(cust.getId());
		// On successful login, add the user to the session.
		session.setAttribute("Customer", cust);
		session.setAttribute("Cart", carts);
		// A flash message will only show on the very next page. Then it will go away.
		// It is useful with redirects since you can't add attributes to the mav.
		redir.addFlashAttribute("message", "Welcome!");
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, RedirectAttributes redir) {
		// invalidate clears the current user session and starts a new one.
		session.invalidate();

		// A flash message will only show on the very next page. Then it will go away.
		// It is useful with redirects since you can't add attributes to the mav.
		redir.addFlashAttribute("message", "We will see you next time. Next time.");
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/signupCustomer")
	public ModelAndView showSignupForm() {
		return new ModelAndView("signupCustomer");
	}

	@PostMapping("/signupCustomer")
	public ModelAndView submitSignupForm(@RequestParam("passWord2") String confirmPassword,
			@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("email") String email, @RequestParam("cardNum") String cardNum,
			@RequestParam("Name") String name, @RequestParam("passWord") String pWord, HttpSession session,
			RedirectAttributes redir) {

		Customer cust = new Customer();
		cust.setName(name);
		cust.setFname(firstName);
		cust.setLname(lastName);
		cust.setEmail(email);
		cust.setCardNum(cardNum);
		cust.setPword(pWord);
		// Find the matching user.
		// Customer existingUser = custDao.findByName(cust.getName());
		List<Customer> custList = custDao.findAll();
		Boolean existingUser = false;
		for (Customer custi : custList) {
			if (custi.getName().equalsIgnoreCase(cust.getName())) {
				existingUser = true;
			}
		}
		if (existingUser) {
			// If user already exists, display an error message.
			return new ModelAndView("signupCustomer", "message",
					"We're sorry. We've already taken someone with that username.");
		}

		if (!confirmPassword.equals(cust.getPword())) {
			// If the user or passwords don't match, display an error message.
			return new ModelAndView("signupCustomer", "message", "Please ensure that your passwords match.");
		}
		ModelAndView mv = new ModelAndView("/verifyCustomer");
		mv.addObject("Name", name);
		mv.addObject("firstName", firstName);
		mv.addObject("lastName", lastName);
		mv.addObject("email", email);
		mv.addObject("cardNum", cardNum);
		mv.addObject("passWord", pWord);
		return mv;
	}

	@RequestMapping("/addCustomer")
	public ModelAndView addCustomer(@RequestParam("firstName") String fName, @RequestParam("Name") String name,
			@RequestParam("lastName") String lName, @RequestParam("email") String email,
			@RequestParam("cardNum") String cardNum, @RequestParam("passWord") String pWord, HttpSession session,
			RedirectAttributes redir) throws IOException {
		Customer cust = new Customer();
		cust.setName(name);
		cust.setFname(fName);
		cust.setLname(lName);
		cust.setEmail(email);
		cust.setCardNum(cardNum);
		cust.setPword(pWord);

		custDao.create(cust);
		List<Cart> carts = cartDao.findByCust(cust.getId());

		// On successful sign-up, add the user to the session.
		session.setAttribute("Customer", cust);
		session.setAttribute("Cart", carts);
		// A flash message will only show on the very next page. Then it will go away.
		// It is useful with redirects since you can't add attributes to the mav.
		redir.addFlashAttribute("message", "Thanks for signing up!");
		return new ModelAndView("redirect:/");
	}

	// This is the second step in OAuth. After the user approves the login on the
	// github site, it redirects back
	// to our site with a temporary code.
	@RequestMapping("/oauth-github-callback")
	public ModelAndView handleGithubCallback(@RequestParam("code") String code, HttpSession session) {
		// First we must exchange that code for an access token.
		String accessToken = githubService.getGithubAccessToken(code);
		// Then we can use that access token to get information about the user and other
		// things.
		Customer githubUser = githubService.getUserFromGithubApi(accessToken);

		// Check to see if the user is already in our database.
		Customer cust = custDao.findByGithubId(githubUser.getGithubId());
		if (cust == null) {
			// if not, add them.
			cust = githubUser;
			custDao.create(cust);
		}

		// Set the user on the session, just like the other type of login.
		session.setAttribute("user", cust);
		// In some apps, you need the access token later, so throw that on the session,
		// too.
		session.setAttribute("githubAccessToken", accessToken);

		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/fixProfile")
	public ModelAndView profile(HttpSession session, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView("fixProfile");
		return mv;
	}

	@PostMapping("/fixProfile")
	public ModelAndView profile2(@RequestParam("firstName") String fName, @RequestParam("Name") String name,
			@RequestParam("lastName") String lName, @RequestParam("email") String email,
			@RequestParam("cardNum") String cardNum, @RequestParam("passWord") String pWord,
			@RequestParam(value = "newWord", required = false) String newWord, HttpSession session,
			RedirectAttributes redir) {
;
		Customer cust = (Customer) session.getAttribute("Customer");
		if (pWord.equals(cust.getpWord()) && !newWord.equals("")) {
			cust.setName(name);
			cust.setFname(fName);
			cust.setLname(lName);
			cust.setEmail(email);
			cust.setCardNum(cardNum);
			cust.setPword(newWord);	
			redir.addFlashAttribute("message", "Thank you for updating all of your precious into.");

		} else if (pWord.equals(cust.getpWord())) {
			cust.setName(name);
			cust.setFname(fName);
			cust.setLname(lName);
			cust.setEmail(email);
			cust.setCardNum(cardNum);
			redir.addFlashAttribute("message", "Thank you for updating your info.");
		} else {
			redir.addFlashAttribute("message", "Check your password.");
		}
		custDao.update(cust);
		session.setAttribute("Customer", cust);
		return new ModelAndView("redirect:/fixProfile");
	}

}
