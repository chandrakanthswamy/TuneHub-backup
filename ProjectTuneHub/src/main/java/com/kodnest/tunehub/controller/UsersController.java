package com.kodnest.tunehub.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.service.SongService;
import com.kodnest.tunehub.serviceImpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;


@Controller
public class UsersController {
	
	@Autowired
	UserServiceImpl serviceImpl;
	
	@Autowired
	SongService songService;
    
	@PostMapping("/registration")
	public String addUser(@ModelAttribute User user ) 
	{       
		 //email taken from registration form
        	String email =user.getEmail();
        	
        	//checking if email as entered in registratoin form is present 
        	//in db or not
        	boolean status = serviceImpl.emailExists(email);
            
        	if(status == false) {
        	serviceImpl.addUser(user);
        	System.out.println("User added");
        	} else {
        		System.out.println("User already exists");
        	}
        	return "login";
        }
	
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session, Model model ) {
		if(serviceImpl.validateUser(email, password) == true){
			String role = serviceImpl.getRole(email);
			session.setAttribute("email", email);
			if(role.equals("admin")) {
				return "adminhome";
			}else {
				
			User user =	serviceImpl.getUser(email);
		boolean userstatus = user.isIspremium();
	List<Song> fetchAllsongs = songService.fetchAllSongs();
	model.addAttribute("songs", fetchAllsongs);
		model.addAttribute("ispremium", userstatus);
		return "customerhome";
			}
			}else {
				
		    return "login";
		}
	}
	@GetMapping("/logout") 
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	}
	

