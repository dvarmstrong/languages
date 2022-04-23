package com.languages.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.languages.models.Language;
import com.languages.service.LanguageService;

@RequestMapping("/")
@Controller
public class LanguageController {
	
	@Autowired
	private LanguageService service;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/languages";
	}
	
	
	
	@GetMapping("/languages")
	public String languages(@ModelAttribute("language")Language language, Model model) {
		List<Language> languages = service.all();
		model.addAttribute("languages",languages);
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String index(@Valid @ModelAttribute("language")Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> languages = service.all();
			model.addAttribute("languages",languages);
			return "index.jsp";
		}
		service.create(language);
		return "redirect:/languages";
		
		}
	
	@GetMapping("/languages/{id}")
	public String view(@PathVariable("id")Long id, Model model) {
		Language language = service.retrieve(id);
		model.addAttribute("language", language);
		return "view.jsp";
	}
	
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id")Long id, Model model) {
		Language language = service.retrieve(id);
		model.addAttribute("language", language);
		return "update.jsp";
	}
	
	@PutMapping("/languages/{id}")
	public String update(@Valid @ModelAttribute("language")Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "/view.jsp";
		} {
			service.update(language);
			return "redirect:/languages";
			}
		
	}
	
	@DeleteMapping("/languages/{id}/delete")
	public String destroy(@PathVariable("id")Long id) {
		service.delete(id);
		return "redirect:/languages";
		
	}
		
	
	
	
	
			
	
	

}
