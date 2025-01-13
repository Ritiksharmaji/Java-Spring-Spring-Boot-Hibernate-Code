 
### --------------------- 
Why do you need a web framework?
Ans= 
•	websites have a lot in common functions like- security, database, URLs, authentication, and more.
•	So should we do this all the time from scratch?
 
So that we can focus on t business logins not to write the replicated code



 

 

 

 
Important of loose coupling in software design
 
 

Example in code 

 
 

 
So during creating a object of class we have to create by our-selph by using the Ioc the IoC will create the object for that class 

 

 


59:45 ⏯️ Spring Container and Configuration

 

 

 

 

01:03:17 ⏯️ Setting Up a Spring Project
1.	we have to create a maven project 
2.	convert that maven to a spring project by injecting some dependency in pom.xml
3.	to add the dependency in the maven project before some time we have to go to Google and download the dependency by searching based on our requirements from Google then search and download the jar files and import that dependency in our project lib folder.
4.	but now’s day  we have to just define the dependey in pom.xml and moven we download those dispendious to define those dependies we can go to https://mvnrepository.com/ and search the required dependeies and then it will give then some code copy those code and paste in the pom.xml and save it then authometically it will download them.
5.	 
6.	 
7.	 copy the code and paste in pom.xml
8.	 
9.	Here before add we need to  define the dependeies tag then paste inside that
10.	 
11.	 
12.	 
13.	 

🛠️ 01:03:17 ⏯️ Setting Up a Spring Project
1)	
01:10:46 ⏯️ Creating Your First Bean
1)	Create a class 
2)	Create a config.xml file and we need to add the Boilerplate for this xml file  from the web by searching the : xml based configuration in spring
a.	<?xml version="1.0" encoding="UTF-8"?>
b.	<beans xmlns="http://www.springframework.org/schema/beans"
c.	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
d.	xsi:schemaLocation="http://www.springframework.org/schema/beans
e.	http://www.springframework.org/schema/beans/spring-beans.xsd">
f.	<!-- Bean definitions here -->
g.	</beans>

3)	 
4)	The use of this xml code is to setup the necessary name space of xml and schema details
5)	









