-------------------------------------SPRING MVC------------------------------------------
video-53
------
	step-1: create a maven project and during creating maven project choose the 
			maven-archetype-webapp
	step-2: after create then maven project one error will come to jsp file to overcome that one 
			goto- build configuration and add the server.
	step-3: download the spring-mvc dependecy from maven website and paste to pom.xml
	ex-
			<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
			<dependency>
			    <groupId>org.springframework</groupId>
			    <artifactId>spring-webmvc</artifactId>
			    <version>5.2.4.RELEASE</version>
			</dependency>
							


----------------------------------------------------------------------------------------------------------------------------------
------------------video-54: Configuring and Code our spring mvc project in just 5 steps-----------------------------------
---------
---------- 1st creating configure file of dispatcher servlet class -------------------
	step-1: 1st configure the dispatcher servlet in web.xml file
		exam
		-----
		<!-- configure the dispatcher servlet-->
		  <servlet>
			  <servlet-name>spring1</servlet-name>
			  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		  </servlet>
		  <servlet-mapping>
			  <servlet-name>spring1</servlet-name>
			  <!-- / this is for define for all the request-->
			  <url-pattern>/</url-pattern>
		  </servlet-mapping>
---------------2nd creating spring configure file -------------------------------			
	step-2: 2nd create spring configuration file -> this file must be contain the dispatcher name which
			we define in web.xml
		example- spring1-servlet.xml
		------
	step-3: take configuration code of xml from previous project.
	
----------3rd configure view resource----------------------------
	step-4: view resource -> the view resource is noting but it is simple bean class which is provided
			by java. so for the class we have to import by identify the proper class name by
			click on enclip cntr + shift+ t 
	step-5: 
	exapme--
		<!-- this is for InternalResourceViewResolver class-->
		  <bean 
		  class="org.springframework.web.servlet.view.InternalResourceViewResolver" 
		  name="viewResolver">   
		  
		  <property name="prefix" value="/WEB-INF/views" />
		  <property name="suffix" value=".jsp"/>
		  </bean>
	
------ 4th create Controller --------------------------------
	step-6: to create controller we have create a class on package  and implements the @Controller 
			annotation on that class top-up
	step-7: creating methods-> we are creating methods in that controller class to handle
			the URL. for that we need to use the @RequestMapping("_names") annotation.

-----------5th creating views ---------------------------------
	step-8: creating a folder name views in WEB-INF and after it create all the jsp files in that location only.	
	
	
	
----------------------------------------------------------------------------------------------------------------
video-55 and 56 Sending Data From Controller to View | Full Concept Explain |
--------
	step-1: we can send the data from controller by two ways 
			1) by using model- we are going to send the data from model(data)object by using the 
			addAttribute(String key,Object value) where String key is the key name to set that value 
			so that when we are try to access it so by using that key we can access and Object value is
			that object which we are sending.
			
			2) by using ModelAndView.->by using addObject(String key , Object value).
	
	step-2: setting the data into controller by using model and getting it from home.jsp by 
			dynamically.	
	
	
-----------------------------------------------------------------------------------------------------------------------
video-56
---------
	step-1: 
------------------------------------------------------------------------------------------------------------------------
video-57 JSP Expression Language to Print Values in Spring MVC Views | JSTL for traversing
---------------
	step-1: to use jsp Expression in jsp page so that we can get the values without using the 
			getAttribute() method of request for that we need to de-activate the pageEgnure in jsp
			by following the syntax.
			example--   ${name}
			
			<h2>name : 
 			<%-- <%= name %>  --%>
 
 			 ${name}
			</h2>	
	
	step-2: to display the collaction types data - when we are displaying the data of collection types
			then that data will come in array formate to display them in each new line we are using the 
			JSTL concept of JSP.
			to use the JSTL in jsp we have to download the dependeny of it from maven and past in pom.xml
			example--
			
			<!-- https://mvnrepository.com/artifact/jstl/jstl -->
			<dependency>
			    <groupId>jstl</groupId>
			    <artifactId>jstl</artifactId>
			    <version>1.2</version>
			</dependency>
						
	step-3: to set the JSTL in jsp page we need to use the below code from oracle by searching the jstl url on chrome
	example--
	 		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	
----------------------------------------------------------------------------------------------------------------------------
video-58 Sending data from View to Controller Complete concept |
-------
	step-1: 
	


---------------------------------------------------------------------------------------
video-63: User Registration using Spring MVC and Spring ORM |
	
	step-1: apply all the dependency of spring-ORM 
	exam dependcy of hiberrnate-core and spring-orm dependcy in pom.xml and mysql-connecter 
	
	step-1: create a Dao class which is only for data transfer
	step-3:
	
	
	
