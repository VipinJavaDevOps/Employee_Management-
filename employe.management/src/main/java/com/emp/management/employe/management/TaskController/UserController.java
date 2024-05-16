package com.emp.management.employe.management.TaskController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.emp.management.employe.management.TaskEntity.User;
import com.emp.management.employe.management.TaskRepository.UserRepository;

import jakarta.validation.Valid;

@Controller 
public class UserController {
	private  final UserRepository userRepository;
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	@GetMapping("/signup")
	public String index() {
		return "index";
	}
	@PostMapping("/adduser")
	public String addUser(@Valid User user,BindingResult result, Model model) {
	        if(result.hasErrors()) {
	        	return "index";
	        }
	        userRepository.save(user);
	        return"user-data";
	}
//	@RequestMapping(value = "/save",method =RequestMethod.POST )
//	public ModelAndView save(@ModelAttribute User user) {
//		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.setViewName("user-data");
//		modelAndView.addObject("user" ,user);
//		return modelAndView;
//		
//	}
	@GetMapping(value="/user-data")
	public String showUserList(Model model) {
		model.addAttribute("users",userRepository.findAll());
		return "datalist";
		
	}

}
