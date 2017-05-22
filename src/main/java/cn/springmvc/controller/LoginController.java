package cn.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.springmvc.model.User;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping("/tologin")
	public String toLogin(){
		return "login";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Model model){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setId(1);
		user.setNickname(username);
		user.setState(1);
		if((username!=null&&password!=null)){
			model.addAttribute(user);
			if(username.equals("czb")&&password.equals("123456")){
				return "import";
			}else{
				return "redirect:/login.jsp";
			}
		}
		return "redirect:/login.jsp";
		
	}

}
