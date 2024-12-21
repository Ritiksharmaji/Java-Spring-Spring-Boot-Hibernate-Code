package springbootwithpostgresql.springbootwithpostgresql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootwithpostgresqlApplication implements CommandLineRunner {

	@Autowired
	private StudentDao studentDao;

	public static void main(String[] args) {

		SpringApplication.run(SpringbootwithpostgresqlApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// this.studentDao.createTable();

		this.studentDao.insetdata("ritik sharma ji", "bihar");
	}

}
