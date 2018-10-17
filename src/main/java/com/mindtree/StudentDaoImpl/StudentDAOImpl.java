package com.mindtree.StudentDaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.StudentDao.AbstractDao;
import com.mindtree.StudentDao.StudentDAO;
import com.mindtree.dto.StudentDTO;
import com.mindtree.entity.Student;
@Repository("studentDAO")

public class StudentDAOImpl extends AbstractDao<Integer,Student>implements StudentDAO {

	
	@Override
	
	public List<Student> getAllStudent() {
		Query query = getSession().createQuery("from Student order by firstname asc ");
		List<Student> studentlist=query.list();
		return studentlist;
	}

	@Override
	public boolean persistStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println("gsdfhskjhf");
		getSession().save(student);
		return false;
	}

	@Override
	public List<Student> isAvailable(String firstName) {
		Query q=getSession().createQuery("from Student where firstname = :name");
		q.setParameter("name", firstName);
		List<Student> st=q.list();
		return st;
	}
	public Student getStudentByStudentId(int studentId) {
		return getByKey(studentId);
	}

	@Override
	public void deleteStudent(int id) {
		getSession().delete(getByKey(id));// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> getSearchStudent(String name) {
		Query q=getSession().createQuery("from Student where firstname =:name");// TODO Auto-generated method stub
		q.setParameter("name",name);
				return q.list();
	}

	@Override
	public boolean persistStudentUpdate(Student student) {
		getSession().saveOrUpdate(student);
		return false;// TODO Auto-generated method stub
		
	}

}
