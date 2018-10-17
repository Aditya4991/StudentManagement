package com.mindtree.StudentDao;

import java.util.List;

import com.mindtree.dto.StudentDTO;
import com.mindtree.entity.Student;

public interface StudentDAO {

	public List<Student> getAllStudent();
	public boolean persistStudent(Student student);
	public List<Student> isAvailable(String firstName);
	public Student getStudentByStudentId(int studentId);
	public void deleteStudent(int id);
	public List<Student> getSearchStudent(String name);
	public boolean persistStudentUpdate(Student student);
}
