package cn.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping("/tologin")
	public String toLogin(){
		return "login";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(false);
		if((username!=null&&password!=null)||session!=null){
			if(username.equals("czb")&&password.equals("123456")){
				session.setAttribute("username", username);
				return "user";
			}else{
				session =  request.getSession();
				session.setAttribute("msg", "用户名或密码不正确，清重新输入！");
				return "redirect:/login.jsp";
			}
		}
		return "redirect:/login.jsp";
		
	}

}
