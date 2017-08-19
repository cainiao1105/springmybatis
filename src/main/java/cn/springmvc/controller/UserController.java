package cn.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;
import cn.springmvc.utils.GridData;
import cn.springmvc.utils.PageInfoModel;


@Controller
@RequestMapping("/user")
public class UserController {
	Logger logger =  Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "initUserMgr", method = RequestMethod.POST)
	public String initUserMgr(){
		return "user/userMgr";
	}
	@RequestMapping("queryUserList")
	@ResponseBody
	public GridData<User> getUserList(PageInfoModel pageModel,HttpServletRequest request,HttpServletResponse response,Model model){
		PageHelper.startPage(pageModel.getPage(), pageModel.getRows(), true);
		List<User> result = userService.queryUserList();
		PageInfo<User> pageInfo = new PageInfo<User>(result);
		GridData<User> data = new GridData<User>();
		data.setRows(result);
		data.setTotal(pageInfo.getTotal());
		return data;  	
	}
}