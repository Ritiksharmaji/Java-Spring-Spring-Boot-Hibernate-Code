package com.spring.jdbc.Dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.spring.jdbc.entities.Student;

@Component("studentDao1")
public class StudentDaoIm implements StudentDao {
	// variable of JdbcTemplate type..
	@Autowired
	private JdbcTemplate jdbctemplate;
	@Override
	public int insert(Student student) {
		 // insert query
        String query = "insert into student(id,name,city)values(?,?,?)";
 int r = this.jdbctemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	@Override
	public int change(Student student) {
		// update method
		String updateQuery = "update student set name=?,city=? where id=?";
int update = this.jdbctemplate.update(updateQuery,student.getName(),student.getCity(),student.getId());
		
		return update;
	}
	
	@Override
	public int delete(int studentid) {
		// Delete method
		String deleteQuery = "delete from student where id=?";
		int deleted = this.jdbctemplate.update(deleteQuery, studentid);
		return deleted;
	}
	
	@Override
	public Student getStudent(int studentid) {
		// select method
		String selectQuery = "select * from student where id =?";
		// creating object for RowMapper interface by RowMapperImp class
		RowMapper<Student> rowmapper = new RowMapperImp();
		
		Student queryForObject = this.jdbctemplate.queryForObject(selectQuery, rowmapper,studentid);
		return queryForObject;
	}
	@Override
	public List<Student> getStudents() {
		// selecting multiple records
		String selectQuery = "select * from student";
		// creating object for RowMapper interface by RowMapperImp class
		RowMapper<Student> rowmapper = new RowMapperImp();
		
		List<Student> queryForMltipleObject = this.jdbctemplate.query(selectQuery, rowmapper);
		return queryForMltipleObject;
	}
	
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	

	

	
	

}
