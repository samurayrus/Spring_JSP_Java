package ru.specialist.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.specialist.dao.CourseService;
import ru.specialist.dao.Course;

@Controller
@RequestMapping("/courses/")
public class CourseController {
	private final Logger logger = 
			LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		logger.info("Listing courses");
		List<Course> courses = courseService.findAll();
		uiModel.addAttribute("courses", courses);
		logger.info("Total courses: "+ courses.size());
		return "courses/list";
		
	}
	
	@RequestMapping(value="update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") int id, Model uiModel)
	{
		uiModel.addAttribute("course", courseService.findById(id));
		return "courses/edit";
	}
	
	@RequestMapping(value="update/{id}", method = RequestMethod.POST)
	public String update(Course course,BindingResult bind, Model uiModel, HttpServletRequest httpservletrequest) {
		
		if(bind.hasErrors())
		{
			uiModel.addAttribute("course", course);
			return "courses/update";
		}
		courseService.save(course);
		return "redirect:/courses/";
	}
}
