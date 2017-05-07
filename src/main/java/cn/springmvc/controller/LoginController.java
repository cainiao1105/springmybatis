package cn.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
	@RequestMapping("/tologin")
	public String toLogin(){
		return "login";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if((username!=null&&password!=null)){
			if(username.equals("czb")&&password.equals("123456")){
				return "import";
			}else{
				return "redirect:/login.jsp";
			}
		}
		return "redirect:/login.jsp";
		
	}

}
