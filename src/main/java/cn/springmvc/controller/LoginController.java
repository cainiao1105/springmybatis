package cn.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping("/tologin")
	public String toLogin(){
		return "login";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Model model){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setNickname("陈志博");
		user.setState(1);
		userService.insertUser(user);
		if((username!=null&&password!=null)){
			model.addAttribute(user);
			if(username.equals("czb")&&password.equals("123456")){
				return "user/userMgr";
			}else{
				return "redirect:/login.jsp";
			}
		}
		return "redirect:/login.jsp";
		
	}

}
