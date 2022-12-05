package org.akee.prj22.school_management.admin.controller;

import java.security.Principal;
import java.util.List;

import org.akee.prj22.school_management.library.model.ClassRoom;
import org.akee.prj22.school_management.library.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClassRoomController {

	@Autowired
	private ClassroomService roomService;

	@GetMapping("/classroom-list")
	public String getAll(Model model, Principal principal) {
		if (principal == null) {
			return "redirect:/signin";
		}
		List<ClassRoom> classrooms = roomService.findAll();
		model.addAttribute("title", "Classroom List");
		model.addAttribute("classroom", new ClassRoom());
		model.addAttribute("classrooms", classrooms);
		model.addAttribute("size", classrooms.size());
		return "classroom-list";
	}

	@PostMapping("/add-classroom")
	public String addClassroom(@ModelAttribute("classroom") ClassRoom room, RedirectAttributes attributes) {
		try {
			if (!roomService.checkValidName(room)) {
				roomService.save(room);
				attributes.addFlashAttribute("message", "Added successfully");
			} else {
				attributes.addFlashAttribute("failed", "Failed to add because duplicate name");
			}
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("failed", "Error server");
		}
		return "redirect:/classroom-list";
	}

	@RequestMapping(value = "/findById", method = { RequestMethod.PUT, RequestMethod.GET })
	@ResponseBody
	public ClassRoom findClassroom(@RequestParam(name = "id") Long id) {
		return roomService.findById(id);
	}

}
