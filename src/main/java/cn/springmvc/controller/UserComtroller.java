package cn.springmvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class UserComtroller {
	Logger logger =  Logger.getLogger(UserComtroller.class);
	@RequestMapping("index")
    public String index(){
		logger.error("test");
		
        return "index";
    }
}
