package org.akee.prj22.school_management.admin.controller;

import java.security.Principal;
import java.util.List;

import org.akee.prj22.school_management.library.model.CourseType;
import org.akee.prj22.school_management.library.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CourseTypeController {

	@Autowired
	private CourseTypeService courseTypeService;

	@GetMapping("/coursetype-list")
	public String getAll(Model model, Principal principal) {
		if (principal == null) {
			return "redirect:/signin";
		}
		List<CourseType> coursetypes = courseTypeService.findAll();
		model.addAttribute("title", "Course Type List");
		model.addAttribute("coursetype", new CourseType());
		model.addAttribute("coursetypes", coursetypes);
		model.addAttribute("size", coursetypes.size());
		return "coursetype-list";
	}

	@PostMapping("/add-coursetype")
	public String addCategory(@ModelAttribute("coursetype") CourseType coursetype, RedirectAttributes attributes) {
		try {
			if (!courseTypeService.checkValidName(coursetype)) {
				courseTypeService.save(coursetype);
				attributes.addFlashAttribute("message", "Added successfully");
			} else {
				attributes.addFlashAttribute("failed", "Failed to add because duplicate name");
			}
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("failed", "Error server");
		}
		return "redirect:/coursetype-list";
	}

}
