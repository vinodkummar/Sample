package com.vinod.studentController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@InitBinder
	/*
	 * Ignore student mobile while performing data binding task
	 */
	public void initBinder(WebDataBinder binder){
		//binder.setDisallowedFields(new String[] {"studentMobile"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy****MM****dd");
		binder.registerCustomEditor(Date.class,"studentDOB", new CustomDateEditor(dateFormat, false));
		
	}
	
	@RequestMapping(value="/admissionForm.html" , method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() throws Exception{
		/* 
		 * Looks for AdmissionForm.jsp page and opens it
		 */
		String exceptionOccured = "ARITHMETIC_EXCEPTION";
		
		if(exceptionOccured.equalsIgnoreCase("NULL_POINTER")){
			throw new NullPointerException("Null pointer exception");
		}
		else if(exceptionOccured.equalsIgnoreCase("IO_EXCEPTION")){
			throw new IOException("IO Exception");
		}
		
		ModelAndView model = new ModelAndView("AdmissionForm");
		return model;
	}
	
	@ModelAttribute
	/*
	 * If there are certain objects that needs to used across multiple pages,
	 * it can be placed in a method with @ModelAttribute
	 */
	public void addingCommonObjects(Model model1){
		model1.addAttribute("headerMessage", "Student Admission Details");
	}
	
	@RequestMapping(value="/submitAdmissionForm.html" , method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1")Student student1, BindingResult result){		
		if(result.hasErrors()){
			/*
			 * If the binding result has errors, it will display a error message and stay on the same AdmissionForm.jsp page
			 */
			ModelAndView model = new ModelAndView("AdmissionForm");
			return model;			
		}
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		return model;
	}
	

	
	
}
