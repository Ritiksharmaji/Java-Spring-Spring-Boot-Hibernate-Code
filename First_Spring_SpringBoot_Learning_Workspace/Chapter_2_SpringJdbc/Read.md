----------------------------------------SPRING JDBC---------------------------------------
	spring JDBC-->  a)spring jdbc is develope on top of jdbc which overcome the problems of jdbc
				    b)it used to communicate with java application to database
					c)java application <---> spring jdbc <--> database
					d)
	1) to create the object of jdbcTemplate class we need a store the dataSource object in jdbcTemplate
		property 
	2) a dataSource is nothing nut a interface which stored all the infor.. about our
		data related to connection with database. so,
		to create a object for dataSource interface we have a class which implemets this interface
		name as DriverManagerDataSource.
		
	3) IT has some methods 
		1) update()-> insert, update,etc..
		2)execute() ->select queries
	
-----------------------------------------------------------------------------
video-30 Creating new Maven Project | Adding Spring JDBC Dependencies |
-----------
	step-1: create a maven project name as springjdbc
	step-2: copy the dependeny spring-core and spring-context from springcore project and past here
	step-3: go-to maven website and dowandload the spring jdbc dependeny based on version
	ex-
	 <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-jdbc</artifactId>
		    <version>6.1.2</version>
		</dependency>
	
	step-4: dowanlaod the mysql-jar dependency from maven website 
	exa-
	 
	 <!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
	<dependency>
	    <groupId>com.mysql</groupId>
	    <artifactId>mysql-connector-j</artifactId>
	    <version>8.0.33</version>
	</dependency>

-------------------------------------------------------------------------------------------------
video-31 Database setup | Configuring Jdbc Template to execute query
-------	 
	 step-1: create database and table in mysql 
	 step-2: create bean class name as Student and config.xml file
	 step-3: give the all the details of DriverManager class and jdbcTemplate interface in xml

------------------------------------------------------------------------------------------------------
video-32 Inserting data to database using Spring JDBC
------- 
	step-1: create JdbcTemplate interface object 
	step-2: create query and fire the query with the help of update() method
	
	step-3: create a package as com.spring.jdbc.Dao to store  StudentDao interface which should has all the method to performs operation 
			on database.
	step-4: create a class as StudentDaoIm which implements the StudentDao interface.
	step-5: create package as com.spring.jdbc.entities to store all the bean class
	step-6: copy the Student class to com.spring.jdbc.entities package.
	

----------------------------------------------------------------------------------------------------------------------------
video-33 Update Operation using Spring Jdbc
------ 
	step-1: create a method in StudentDao interface name as change()
	step-2: define the difination of change() method in StudentDaoIm class and write the 
			update query and fire it by update() method.
	step-3: in App.java container call the change() method in-place of insert() method.

---------------------------------------------------------------------------------------
video-35 Delete Operation using Spring JDBC 
---------
	step-1: add the method delete() in StudentDao interface 
	step-2: implements that method in StudentDaoIm bean class.
	step-3: call the delete method in app.java conatainer with given a id
	

------------------------------------------------------------------------------------------
video-36  Row Mapper Concept | Fetching data using Spring JDBC
----------
	step-1: Row Mapper -> resultset object will goes into Row Mapper object and row mapper converts
			that object to class objects.
			but problem is that the Row mapper is a interface
			so we can't create object direct for it for that we have
			to create a class which implements the Row mapper interface.
	step-2:

------------------------------------------------------------------------------------------
video-37 Selecting Single Object using Spring Jdbc | Row Mapper
------------
	step-1: to select the single record we are using the RowMapper interface to execute the query
			to execute that rowMethod interface we are creating a class as RowMapperImp.
			and implements all method in that class
	step-2: 
	
	
----------------------------------------------------------------------------------------------
video-38 Selecting Multiple Objects using Spring Jdbc|


----------------------------------------------------------------------------------------
video-40
	step-1: create a class as jdbcConfig.java 
	step-2: and create three method in that class to define those three configuration details
			which we have done in conf.xml 
			like for 
			1)DriverManagerDataSource class configuration.
			2)JdbcTemplate class configuration details.
			3)StudentDaoIm bean class configuration details.
	
	step-3: use the annocations in jdbcConfig.java class like @Configuration on class ,@Bean() on methods
	step-4:		
	
---------------------------------------------------------------------------------------------------
video-41 and 42 Autowiring with Spring Jdbc | Spring Jdbc Tutorial | Automatic Wiring
----------
	step-1: here we are not going to create the method for return the object of StudentDao bean for that we
			we going to using the 	Autowiring annotaion.
			for thata we are using the @Component annotaion on StudentDaoIm class and @ComponentScan(basePackages ={"}) in JbcdConfig.java
			after that use the @Autowired 
	
	
	
----------------------------------------------------------------------------------------------------
