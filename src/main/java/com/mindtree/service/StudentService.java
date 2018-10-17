package com.mindtree.service;

import java.util.List;

import javax.validation.Valid;

import com.mindtree.dto.StudentDTO;
import com.mindtree.entity.Student;

public interface StudentService {

	public void saveStudent(StudentDTO studentDTO);

	public boolean checkAvail(String firstName);
	public List<Student> gatAllStudentList();

	public StudentDTO getStudentById(int studentId);

	public void deleteStudent(int id);

	public List<Student> searchStudent(String name);

	public void saveStudentUpdate(@Valid StudentDTO student);
}
