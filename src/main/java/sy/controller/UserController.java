package sy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.model.User;
import sy.service.UserServiceI;

@Controller
@RequestMapping("/userController")
public class UserController {
	@Resource
	private UserServiceI userService;

	/*
	 * public UserServiceI getUserService() { return userService; }
	 */

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	@RequestMapping("/{id}/showUser")
	public String showUser(@PathVariable String id, HttpServletRequest request) {
		User u = userService.getUserById(id);
		request.setAttribute("user", u);
		return "showUser";
	}

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		String userId = request.getParameter("id");
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

}
