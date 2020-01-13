package com.johnabbott.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnabbott.test.model.StudentEntity;

@Repository
public class HibernateStudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int insertStudent(StudentEntity std) {
		sessionFactory.getCurrentSession().save(std);
		sessionFactory.getCurrentSession().save(std.getAddress());
		sessionFactory.getCurrentSession().save(std.getTeacher());
		return 1;
	}

	@Override
	public List<StudentEntity> getStudents() {
		//Student is not the table name => it is the class name(@Entity)
		return getSession().createQuery("from StudentEntity", StudentEntity.class).list();
	}

	@Override
	public StudentEntity getStudentById(int studentId) {
		return (StudentEntity) getSession().get(StudentEntity.class, studentId);
	}
	
	@Override
	public StudentEntity getStudentByName(String studentName) {
		String hql = "from StudentEntity where firstName= :student_name";
		Query query = getSession().createQuery(hql);
		query.setParameter("student_name",studentName);
		if (query.list().size() > 0) {
			return (StudentEntity)query.list().get(0);
		}
		else {
			return null;
		}
			
		
	}

	@Override
	public boolean deleteStudent(int studentId) {
		StudentEntity fetchedStudent = getStudentById(studentId);
		getSession().delete(fetchedStudent);
		return true;
	}

	@Override
	public boolean updateStudent(StudentEntity std) {
		getSession().update(std);
		return true;
	}

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
