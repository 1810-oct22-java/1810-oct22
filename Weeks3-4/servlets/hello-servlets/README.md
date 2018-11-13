# About hello-servlets

###### Steps to recreate this Application
1. Make a new Maven project
	1. Skip archetype selection (make simple project)
	1. packaging = war
1. Add dependencies to POM
1. Create web.xml (Deployment Descriptor)
	1. right click on project
	1. Java EE tools 
	1. Generate Deployment Descriptor Stub
1. Make new Servlet class
	1. generate new class in appropriately named package
	1. make said class extend javax.servlet.http.HttpServlet
	1. add doXXX methods to respond to requests appropriately 
1. Configure class as servlet
	1. either add `@WebServlet` to top of class, OR
	2. add `<servlet>` and `<servlet-mapping>` to web.xml
	
--
###### Topics covered in this example:
* web.xml
* servlet-config
* servlet-context
* getting parameters from forms 
* employing a service layer to carry out business logic 
* PrintWriter
* ObjectMapper
* [load-on-startup](https://www.javatpoint.com/load-on-startup)
* [`@WebServlet`](https://www.codejava.net/java-ee/servlet/webservlet-annotation-examples)
	