package com.johnabbott.test.dao;

import java.util.List;

import com.johnabbott.test.model.StudentEntity;

public interface StudentDao {
	public int insertStudent(StudentEntity std); //Create
	
	public List<StudentEntity> getStudents(); // Read
	
	public StudentEntity getStudentById(int studentId); // Read
	
	public StudentEntity getStudentByName(String studentName); //Read
	
	public boolean deleteStudent(int studentId); //DELETE
	
	public boolean updateStudent(StudentEntity std); // UPDATE
	
	
}
