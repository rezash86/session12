package com.johnabbott.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.johnabbott.test.model.StudentEntity;

public class StudentMapper implements RowMapper<StudentEntity> {

	@Override
	public StudentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new StudentEntity(rs.getInt("id"), rs.getString("firstname"),
				rs.getString("lastname"), rs.getInt("age"));
	}

}
