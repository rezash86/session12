package com.johnabbott.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.test.dao.StudentDao;
import com.johnabbott.test.model.StudentEntity;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	List<StudentEntity> listStudents;
	
	public StudentServiceImpl() {
		listStudents = new ArrayList<StudentEntity>();
		
		listStudents.add(new StudentEntity(1, "toto1", "popo1", 15));
		listStudents.add(new StudentEntity(2, "toto2", "popo2", 14));
		listStudents.add(new StudentEntity(3, "toto3", "popo3", 24));
		listStudents.add(new StudentEntity(4, "toto4", "popo4", 34));
	}
	
	@Override
	public List<StudentEntity> getStudents(){
		return studentDao.getStudents();
	}

	@Override
	public boolean addStudent(StudentEntity std) {
		return studentDao.insertStudent(std) > 0 ;
	}

	@Override
	public StudentEntity getStudentById(int studentId) {
		return studentDao.getStudentById(studentId);
	}

	@Override
	public boolean deleteStudent(int studentId) {
		return studentDao.deleteStudent(studentId);
	}

	@Override
	public boolean updateStudent(StudentEntity std) {
		return studentDao.updateStudent(std);
	}
}
