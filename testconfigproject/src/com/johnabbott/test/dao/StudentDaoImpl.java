package com.johnabbott.test.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.johnabbott.test.model.StudentEntity;


public class StudentDaoImpl implements StudentDao {

	JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_STUDENT = "insert into " + "student(firstname, lastname, age) values(?, ?, ?)";

	private final String SQL_UPDATE_STUDENT = "update student set firstname= ? , lastname =? , age = ? where id = ? ";

	private final String SQL_SELECT_STUDENT = "select id, firstname, lastname, age" + " from student";
		
	private final String SQL_SELECT_STUDENT_BY_ID = "select id, firstname, lastname, age from student where id = ?";
	
	private final String SQL_DELETE_STUDENT = "delete from student where id = ? ";

	public StudentDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int insertStudent(StudentEntity student) {
		return jdbcTemplate.update(SQL_INSERT_STUDENT, student.getFirstName(), student.getLastName(), student.getAge());
	}

	@Override
	public List<StudentEntity> getStudents() {
		return jdbcTemplate.query(SQL_SELECT_STUDENT, new StudentMapper());
	}

	@Override
	public StudentEntity getStudentById(int studentId) {
		return jdbcTemplate.queryForObject(SQL_SELECT_STUDENT_BY_ID, 
				new Object[]{studentId}, new StudentMapper());
	}

	@Override
	public boolean deleteStudent(int studentId) {
		int deleteResult = jdbcTemplate.update(SQL_DELETE_STUDENT, studentId);
		return deleteResult > 0;
	}

	@Override
	public boolean updateStudent(StudentEntity std) {
		int updateResult = jdbcTemplate.update
				(SQL_UPDATE_STUDENT, 
						std.getFirstName(), 
						std.getLastName(), 
						std.getAge(),
						std.getId());
		return updateResult > 0;
	}

	@Override
	public StudentEntity getStudentByName(String studentName) {
		// TODO Auto-generated method stub
		return null;
	}

}
