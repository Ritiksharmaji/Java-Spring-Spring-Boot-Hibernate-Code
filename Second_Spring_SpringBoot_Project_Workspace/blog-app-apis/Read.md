session-1 creating the user model and AIPS
------------------------------------------------
before create the userModel we have create a following packages to mantains the data 
1) com.blogapp.apis.entities -> this package will store all the java class which is used to create a table for 
	database and it should me secure 

2)com.blogapp.apis.payloads -> this package will store all the java class which can be used to communicate with service class to 
	entities to make the database secure.

2)com.blogapp.apis.repositories -> in this package we create a interface which extends the JPARepository interface which provides
	more methods to deails with database like - creating tables query method and CURD method and mores..

3)com.blogapp.apis.services -> it will store the a interface which extends the repositriy packages interface aso that we can use all the 
	importans method of JPA by it and it also store some addtional methods of its.
	
4)com.blogapp.apis.services.imps --> in this packages we create a class which implemts the services packages interface to implemts its all method and to use the JPA method to performs the business logics here.

-----------------------------------------------------------------
session -3 
-------------

create class to handle the Errors name as GlobleExceptionHandler  which handle the exception globlelly
so all the exception can be handle by here also and it  implemets the method to handle the Resource Not Found Exception so when ever the at client side Resource Not Found Exception is  happed then this method (resourceNotFoundExceptionHandler() ) will we execute than send the response. 

---------------------------------------------------------------------------------
session-4 ModelMapper dependency
--------------

	now to convert one object to other object we have create two method dtoTOUser() and userToDto() 	which are converting user object to userDto object and userDto object to user object but for more 	than two and many class or object it is not good to write code to achive it we are configurating 	the dependency of 	ModelMapper jar
	in pom.xml

for that we have to get it by offical maven website -> https://mvnrepository.com/artifact/org.modelmapper/modelmapper

<!-- https://mvnrepository.com/artifact/org.modelmapper/modelmapper -->
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>3.1.0</version>
</dependency>


------------------------------------------------------------------------------------------------------------------------------------
session-5 validation of data
---------------
we are going to validate the data so that data will be stored in well formate for that we are going to do validation at server 	side like- email validation ,number of charecter in name etc.

step1: inject dependecy of the hibernate spring-boot spring-boot-starter-validation
step-2: use the @Annocation on required files
step-3: enable the @Annocation by container
step-4: format the error 
-----------------
step-1 

<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
    <version>2.6.6</version>
</dependency>
----------------
step-2 : apply all the @Annotaion on required fileds on  UserDto.java class of com.blogapp.apis.payloads package.
step-3: to enable these Annotaion we have to use the @Valid annoation on Container from this method request is comming.

------------------------
step-4: format the error SMS to display the Error in well format
to handle the rise exception called MethodArgumentNotValidException by GlobleExceptionHandler class to create a method called 


----------------------------------------------------------------------------------------------------------------------------------
session-6 creating the Category APIS
----------------------
step-1: create class entity User.java
step-2: create class CategoryDto.java
step-3: create interface CategoryRepo.java
step-4: create interface CategoryService.java
step-5: create class CategoryServiceImpl.java
step-6: create CategoryController.java

-------------------------------------------------------------------------------------------------------------------
session-7 Creating Post class entity and Relationship between post , user and Category to maintain the join concept
---------------------------------------
step-1: create class entity Post.java
step-2: create class PostDto.java
step-3: create interface PostRepo.java
step-4: create interface PostService.java
step-5: create class PostServiceImpl.java
step-6: create PostController.java

----------------------------------------------------------------------------------------------------------------
session-8 Implement Pagination in very simple ways in API
-------------------------------

here we are going to apply the Pagination to filter the pages

	In your 'PostServiceImpl' class, you are creating a 'Pageable' object 'p' and passing it to the
	`findA11() ' method of your 'PostRepo' with 'pageNumber' and 'pageSize'. However, the
	'pageNumber' in 'PageRequest' is zero-based, meaning the first page is '0', not '1'. Therefore,
	when you pass 'pageNumber = 1', it will actually retrieve the second page.
	To fix this issue and retrieve the first page when `pageNumber = 1', you need to subtract '1' from
	the 'pageNumber' when creating the 'PageRequest'. Here's how you can fix it:
			 
to overcome the above we have to set the value of pageNumber 0 not 1 in container.

----------------------------------------------------------------------------------------------------------------------
session-9 Modifying Post Response in POST API | Its very important for creating API 
------------------------------------
to modify the Post API response we are creating a class called PostResponse which hold the content fileds  and some more
to send the data in more easy ways.so that we can apply the sorting and pagination 
after creating this class we have to change the return types of getAllPost() from PostServiceImpl class to PostResponse and implements code to return the PostResponse data and also change the return types of ResponseEntity<List<PostDto>>> getAllPost method(handler) of PostController to ResponseEntity<PostResponse> getAllPost . and implements the code.

after change this all run and test and also apply this one to two more method of PostService on 
1)List<PostDto> getPostsByCategory(Integer category_id); . 2)List<PostDto> getPostsByUser(Integer user_id);

apply it also on getallpost by users and category.



-------------------------------------------------------------------------------------------------------------
session-10 Implementing Sorting in Blogging Application in Spring Boot 
---------------------------------
for the sorting we have to implements one more arguments to List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);
based on sorting parameters

1)public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy); ---> to sort the data by either postId, postContent and postTitle 


2)public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir); --> to sort the data by either desc order or asc order 


---

------------------------------------------------------------------------------------------------
session-11 Implementing Searching in our Backend Application 
----------------------
step-1: we are creating a costume jpa method for perfomrms the like query on database called List<Post> findByPostTitleContaining(String postTitle); and here notes that to give the name be careful 

step-2: create a method is PostService interface called List<PostDto> searchPosts(String keyword); to override in its implemented class

step-3: override the List<PostDto> searchPosts(String keyword); method in PostServiceImpl and write the code.

step-4: create a handler in PostContainer called public ResponseEntity<List<PostDto>> serchPostByTitle to handle the search request.

---------------------------------------------------------------------------------------------------------
session-12 One Good Practice that makes your project best |
--------------------------
we are going to learn that how to remove and maintain the hardcode in your application for that we are create a separate constant for them.
which make code-reusable, less-code, easy-to-chnage or update etc.

step-1:creating a class AppConstants in packages-> com.blogapp.apis.config to implemts all constanst data
sep-2: change all the data which is hard-coded from PostController


-----------------------------------------------------------------------------------------------------------
session-13 Working on Post Image in one short | Uploading Image for Post | Serving Post Image
------------------------------
here we are going to insert the pics by post and store in directory.

step-1: creating a interface called FileService.java
step-2: creating a class which implemtns all the methods of FileService interface called FileServiceImpl.java.
step-3: provides the detalis of MUltitypes data in application.properties 

	like- 
# this is for image perpose 
spring.servlet.multipart.max-file-size = 20MB
spring.servlet.multipart.max-request-size = 20MB
project.image = image/

step-4: create a handler in PostController.java called ResponseEntity<PostDto> uploadPostImage
step-5: send the request and check the response.

-------------------------------------------------------------------------------------------------------------------
session-14 Complete Comment API in one short using Spring Boot
-------------------------------
*** -> have to do

 1)here we are creating a comment api so comment has relationship between comment(many comment for a single post)
 2)create relationship between user and comments where many comments for a single user.
 3)create relationship between category and comments where many comments for a single category.
 4)to get related comments automatically when we call the Post we are declare a comment.
 5)create a commentDto class 
 6)creating a CommentRepo interface
 7) creating a CommentService interface
 8) creating a CommentServiceImpl class
 9) creating a CommentContianer class

by above we achive that to get all the post by particular post 
i have to two more things there setting the comment for particular user and category 
----------NOTE----------------------
when ever we are submit the data of comments from url then it properlly taking the post id but then userId and categoryId not taking property to verify it we have to create GUI and then check if also not comming then we will implents the below handle for it in-place of present hander

//@PostMapping("user/{userId}/category/{categoryId}/post/{postId}/createComment")

and also have to  implements all the CURD operation for comments


------------------------------------------------------------------------------------------------------------------------------------------
session-15 Securing Rest APIs in Backend Application
--------------------------------
here spring-provies the form based authentication features to login and logout for access the resources

by this session we are going to includes one feature called spring security so that without login no-one can do any post, edit there post and so on.
step-1: inject the spring-security dependency in pom.xml
like-
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		
step-2: apply the spring-security configure in application.properites 
like-
#appy the spring-security configuration details
logging.level.org.springframework.security=DEBUG

step-3:  configure the spring-security details in application.properties
here when we inject the spring-security to application and run it then by-default it will create a password which will show in console and if we try to access any resource from follow the url then that will show user unuthentication beacuse spring-security by-default it secure all the resource to access then we have to login the url with respect to user name as user and password as given console

step-4: we can also change the default user name and password by confire it in application.properties 
like-
#manege the user detalis
spring.security.user.name==ritik
spring.security.user.password=ritik
spring.security.user.roles=ADMIN

-------------------------------------------------------------------------------------------------------------------------------
session-16 Complete Basic Authentication with Database | Securing Rest APIS
-------------------------------------------------------
WE KNOW that spring-security provides the form based authentication so we are using the REST apis so we are going to convert in in basic form.

step-1: create a class in package ---> com.blogapp.apis.config called ---> SecurityConfiguration.java

step-2: extend that class the other predefine is WebSecurityConfigurerAdapter , here problem  is that  The WebSecurityConfigurerAdapter class has been deprecated in recent versions of Spring Security.
Starting from Spring Security 5.7.0-M2, the recommended approach is to configure security using other alternatives, such as SecurityFilterChain. and 
If you’re using an older version of Spring Security (before 5.7.0-M2), you can find the WebSecurityConfigurerAdapter class in the spring-security-config JAR.
To include it in your project, add the following Maven or Gradle dependency:
example- 

<dependency>
		    <groupId>org.springframework.security</groupId>
		    <artifactId>spring-security-config</artifactId>
		    <version>5.3.0.RELEASE</version>
</dependency>

----------------NOTE-----------------------
the above ways show some error so that we are using the  registering a SecurityFilterChain bean way for that. we need to implements the method as 
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    	
    	http.authorizeRequests((authz)->authz
    			.anyRequest()
    			.authenticated())
    	.httpBasic();
    	return http.build();
    }
and test them.

step-3: create a class Role.java entity to store the role details of user and here i user can have many role and also many roles can have many user so the relationship between user and role must be many-to-many.

step-4: give the mapping between this both classes. 

STEP-5: RUN AND check the databases created user_role and role table.

step-6: now remove the details of user from application.properties and create some class which can store them in database.

step-7: create a method in UserRepo.java  for user to identify the user for role

step-8: create a class CustomUserDetailsService.java in a package com.blogapp.apis.security and implements the above method 

step-9: after calling that findBYEmail() method here we have the object type of user but we need to return the types of UserDetails so we need to  implemetns the UserDetails to user class so that we can return the user

step-10: after return the user object we have to authenticate the basic authentication with database so we are create a 
		  method in SecurityConfiguration class which handle the configure the basic configuration with database in  spring boot using spring security

step-11: after this all we are storing the password in encoding format so create object in main class of spring application

--------------------------------------------------------------------------------------------------------------------------------------
session-17 create user and useRepo

step-1: add the dependecy of jwt to pom.xml
like- 
<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency>

step-2: Create JWT authenticationEntryPoint implements AuthenticationEntryPoint

we are create a class JWT_authenticationEntryPoint in package---> com.blogapp.apis.security ,  which implements the AuthenticationEntryPoint and we are overriding a method called 'commence' for if any un-authentication person try to access the resource then it will throw a error.

step-3: Create JWTTokenHelper

it will inclueds all the method related to token operation like- create token, send token etc. so we are create a class for it JWTTokenHelper 

step-4:  JwtAuthenticationFilter  extends OncePerRequestFilter 
 we are create a class JwtAuthenticationFilter which extends the OncePerRequestFilter which filter the request just before access the APIS. and overrides the implemtnded method called doFilterInternal  for below operation this method will executed at each and every time for checking the request header.
              
a) Get jwt token from request- 
b) Validate token
c) Get user from token
d) Load user associated with token
e) Set spring security 


5. Create JwtAuthResponse- 
we are create a JwtAuthResponse.java class which has those response which we will send with data.

6. Configure JWT in spring security config---
we have to configure the jwt to spring security in securityConfig.java class by


7. Create login  api to return token
8. Test the application
---------------------------------------------------------------------------------------------------------
###
TO IMPLEMENTS THE SWAGGER 
-----------------------------------------
To implments the swagger for our project we need to download or inject the dependecy of swagger by following below maven 
ex-
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>

step-2: after inject the swagger dependency in pom.xml we need to enable the @EnableWebMvc in SecurityConfiguration.java and to implements the
		all url we need to write the .requestMatchers("/v3/api-docs").permitAll() which is used to access all predefine url with proper description.
		
step-3: after implements above steps when we run the code then by following that URL we can see multiples url which are already in that swagger so to implemets our url we need to use array of string and paste all the url in that string array.

