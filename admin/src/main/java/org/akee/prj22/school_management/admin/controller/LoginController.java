package org.akee.prj22.school_management.admin.controller;

import org.akee.prj22.school_management.library.dto.AdminUserDto;
import org.akee.prj22.school_management.library.model.AdminUser;
import org.akee.prj22.school_management.library.service.impl.AdminUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class LoginController {

	@Autowired
	private AdminUserServiceImpl userService;

	@GetMapping("/")
	public String rootForm(Model model) {
		model.addAttribute("title", "Sign In");
		model.addAttribute("userDto", new AdminUserDto());
		return "signin";
	}

	@GetMapping("/index")
	public String home(Model model) {
		model.addAttribute("title", "Home");
		return "index";
	}

	@GetMapping("/signin")
	public String signinForm(Model model) {
		model.addAttribute("userDto", new AdminUserDto());
		model.addAttribute("title", "Sign In");
		return "signin";
	}

	@PostMapping("/do-signin")
	public String doSignin(@Valid @ModelAttribute("userDto") AdminUserDto userDto, Model model) {
		AdminUser user = userService.findByUserName(userDto.getUserName());
		if (!new BCryptPasswordEncoder().matches(userDto.getPassword(), user.getPassword())) {
			model.addAttribute("userDto", userDto);
			model.addAttribute("error", "Invalid username or password!");
			return "redirect:/signin?error";
		}
		return "redirect:/index";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("userDto", new AdminUserDto());
		model.addAttribute("title", "Register");
		return "register";
	}

	@PostMapping("/register")
	public String processRegisteration(@Valid @ModelAttribute("userDto") AdminUserDto userDto, BindingResult result,
			Model model) {
		try {
//			session.removeAttribute("message");
			if (result.hasErrors()) {
				model.addAttribute("userDto", userDto);
				result.toString();
				return "register";
			}
			AdminUser user = userService.findByUserName(userDto.getUserName());
			if (user != null) {
				model.addAttribute("userDto", userDto);
				model.addAttribute("error", "Your username has been registered!");
				return "register";
			}
			if (userDto.getPassword().equals(userDto.getRepeatPassword())) {
				userService.save(userDto);
				model.addAttribute("success", "Register successfully!");
				return "redirect:/signin";
			} else {
				model.addAttribute("error", "Password dosen't match!");
				return "register";
			}
		} catch (Exception e) {
			model.addAttribute("error", "Error: Can not register!");
		}

		return "register";
	}

	@GetMapping("/forgot-password")
	public String forgotPassword(Model model) {
		model.addAttribute("title", "Forgot Password");
		return "forgot-password";
	}

}
