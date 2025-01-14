package com.springcore.jdbc_2.WithXmlConfiguration;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class RowMapperImp  implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// here we are retrieving the data from database by using the object
		// of ResultSet and stored into the student object as below
		Student s = new Student();
		s.setId(rs.getInt(1));
		s.setName(rs.getString(2));
		s.setCity(rs.getString(3));
		// here we are storing the retrieve data to student object.
		return s;
	}

}
