package com.javatpoint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.beans.Emp;
import com.javatpoint.dao.EmpDao;



@Controller

public class UserLoginController {

	@Autowired 
	private EmpDao userDao;
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String init(Model model) {
	    model.addAttribute("msg", "Please Enter Your Login Details");
	    return "login";
	  }


	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("userId") String userId, @RequestParam("password") String password , Model m) {

		ModelAndView mv = new ModelAndView();

		Emp user = new Emp();
		user.setName(userId);
		user.setPassword(password);
		
		
		String name = userDao.loginUser(user);
		int ad=userDao.admin(user);
		if (name != null) {

			mv.addObject("msg", "Welcome " + name + ", You have successfully logged in.");
			List<Emp> list=userDao.getEmployees();  
	        m.addAttribute("list",list);
	        
	        mv.setViewName("viewemp");
	        
	        
			

		} else {

			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("login");
		}

		return mv;

	}
	

}