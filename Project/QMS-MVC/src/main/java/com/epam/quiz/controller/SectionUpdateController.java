package com.epam.quiz.controller;

import com.epam.quiz.exception.SectionNotFoundException;
import com.epam.quiz.service.SectionValidationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sectionupdate")
public class SectionUpdateController {

	@Autowired
	private SectionValidationServiceImpl sectionValidationServiceImpl;
	
	@PostMapping("/savesection")
	public String saveSection(@RequestParam("sectionname") String sectionName)
	{
	
		boolean result = sectionValidationServiceImpl.addSectionTagChecker(sectionName);
	
		if(result)
		{
		  return "/updatequiz/sectionnameexist";
		}
	
		return  "adminpages/adminpage";
	}
	
	@PostMapping("/checksection")
	public String checkSection(@RequestParam("oldsectionname") String oldSectionName,Model model)
	{
		boolean result = sectionValidationServiceImpl.isSectionTagExistChecker(oldSectionName);
		model.addAttribute("oldsectionname", oldSectionName);
		if(!result)
		{
			throw new SectionNotFoundException();
		}
		return "/updatequiz/updatesectiontag";
	}
	
	@PostMapping("/updatesection")
	public ModelAndView updateSection(@RequestParam("oldsectionname") String oldSectionName,@RequestParam("newsectionname") String newSectionName)
	{
		ModelAndView md = new ModelAndView();
		boolean result = sectionValidationServiceImpl.addSectionTagChecker(newSectionName);
		if(result)
		{
			md.setViewName("/updatequiz/sectionnameexist");
		}
		
	    sectionValidationServiceImpl.updateSectionTagChecker(oldSectionName, newSectionName);
		md.setViewName( "adminpages/adminpage");
		return md;
	}
	
	
	@ExceptionHandler(SectionNotFoundException.class)
	public String sectionNotFoundExceptionHandler()
	{
		return "/updatequiz/sectionnotfoundexception";
	}
}
