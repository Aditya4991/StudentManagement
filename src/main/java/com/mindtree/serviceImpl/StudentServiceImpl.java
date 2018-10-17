package com.mindtree.serviceImpl;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.StudentDao.StudentDAO;
import com.mindtree.dto.StudentDTO;
import com.mindtree.entity.Student;
import com.mindtree.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private Student student;
	@Autowired
	private StudentDAO studentDao;
	@Autowired(required=true)
	private StudentDTO studentdto;

	@Override
	public void saveStudent(StudentDTO studentDTO) {
		student.setFirstName(studentDTO.getFirstName());
		student.setLastName(studentDTO.getLastName());
		student.setEmailId(studentDTO.getEmailId());
		studentDao.persistStudent(student);

	}

	public boolean checkAvail(String firstName) {
		List<Student> st=studentDao.isAvailable(firstName);
		if(st.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Student> gatAllStudentList() {
		List<Student> studentList=studentDao.getAllStudent();
		return studentList;
	}
	
	public StudentDTO getStudentById(int studentId) {
		student=studentDao.getStudentByStudentId(studentId);
		studentdto.setFirstName(student.getFirstName());
		studentdto.setLastName(student.getLastName());
		studentdto.setEmailId(student.getEmailId());
		return studentdto;
	}

	@Override
	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> searchStudent(String name) {
		List<Student> tr = studentDao.getSearchStudent(name);
		
		return tr;
	}

	@Override
	public void saveStudentUpdate(@Valid StudentDTO studentDTO) {
		student.setFirstName(studentDTO.getFirstName());
		student.setLastName(studentDTO.getLastName());
		student.setEmailId(studentDTO.getEmailId());
		studentDao.persistStudentUpdate(student);// TODO Auto-generated method stub
		
	}
}
