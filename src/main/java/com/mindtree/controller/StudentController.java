package com.mindtree.controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.dto.StudentDTO;
import com.mindtree.entity.Student;
import com.mindtree.service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {

	@Autowired
	public StudentService studentService;

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		// model.addAttribute("student",new Student());
		return "index";
	}

	@RequestMapping("/StudentForm")
	public String studentForm(ModelMap model) {
		model.addAttribute("student", new StudentDTO());
		return "studentForm";
	}

	@RequestMapping("/submitform")
	public String submitForm(@Valid @ModelAttribute("student") StudentDTO student, BindingResult result, Model model) {
		boolean error = false;
		if (student.getFirstName().isEmpty()) {
			result.rejectValue("firstName", "error.firstName");
			error = true;
		}
		if (!studentService.checkAvail(student.getFirstName())) {
			result.rejectValue("firstName", "error.exist");
			error = true;
		}
		if (error) {
			return "studentForm";
		}
		/*
		 * if(result.hasErrors()) { return "studentForm"; }
		 */

		studentService.saveStudent(student);
		System.out.println("Student Name :" + student.getFirstName() + " " + student.getLastName());
		return "confirmation-form";
	}
	
	@RequestMapping("/submitformUpdate")
	public String submitFormUpdate(@Valid @ModelAttribute("student") StudentDTO student, BindingResult result, Model model) {
		boolean error = false;
		if (student.getFirstName().isEmpty()) {
			result.rejectValue("firstName", "error.firstName");
			error = true;
		}
		if (!studentService.checkAvail(student.getFirstName())) {
			result.rejectValue("firstName", "error.exist");
			error = true;
		}
		if (error) {
			return "redirect:/getAllStudent";
		}
		/*
		 * if(result.hasErrors()) { return "studentForm"; }
		 */

		studentService.saveStudentUpdate(student);
		System.out.println("Student Name :" + student.getFirstName() + " " + student.getLastName());
		return "redirect:/getAllStudent";
	}
	@RequestMapping(value="/getAllStudent")
	public ModelAndView getStuDentList() {
		List<Student> studentList = studentService.gatAllStudentList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("student-List");
		modelAndView.addObject("studentList", studentList);
		return modelAndView;
	}

	@RequestMapping("/updateStuent")
	public String updateStudent(@RequestParam("studentId") int studentId,Model model) {
		StudentDTO studentDTO=studentService.getStudentById(studentId);
		model.addAttribute("student",studentDTO);
		return "studentFormUpdate";
	}

	@RequestMapping("/delete-person")
	public String deleteStudent(@RequestParam("id") int id){
		
		studentService.deleteStudent(id);
		return "redirect:/getAllStudent";
	}
	
	@RequestMapping("/search")
	public String searchStudent(@RequestParam("searchName") String name,Model model) {
		List<Student> studentList = studentService.searchStudent(name);
		Iterator<Student> tp= studentList.iterator();
		while(tp.hasNext()) {
			System.out.println("hhhhhhh"+tp.next().getFirstName());
		}
		model.addAttribute("studentList",studentList);
		
		return "student-List";
		
	}
}
