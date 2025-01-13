video-43 and 44 Spring ORM Complete Setup | New Project | Adding Dependencies in Detail | Spring ORM
--------
	step-1: create a Maven project name as SpringORM and follow same setup as preous
	step-2: download the dependency 
		1) spring-core
		2)spring-context
		3)spring-Hibernate
		
	
	step-3: creating packages com.spring.orm.dao and com.spring.orm.entities and congig.xml
			creating classes based on requirement.
	step-4: setting the Bean class and Dao class
	step-5:  after this all when we run the code then it will show the error that 
			'Write operations are not allowed in read-only mode 
			Turn your Session into FlushMode.COMMIT/AUTO or 
			remove 'readOnly' marker from transaction definition' 
			so, we need to declare one more dependecy in xml file of Hibernate TranscationManager .
			and add the annotaion on studentDao class to allow that method for write operation
			ex-
			@Transactional => to perform the write operation
	
	
----------------------------------------------------------------------------------------------------------------
video-46
	step-1: 

	
	
--------------------------------------------------------------------------
video-47
	step-1: creating object for bufferReader class.
		
	
	
	
	
------------------------------------------------------------------------------------------------------------------

	
	
	
	
	
	
	
	