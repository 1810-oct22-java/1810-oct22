package TryAjaxServletsOnePage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/tryone")
public class TryAjaxServletsOnePage extends HttpServlet{


	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		 out.print("<!DOCTYPE html>\r\n" + 
		 		"<html lang=\"en\">\r\n" + 
		 		"<head>\r\n" + 
		 		"    <meta charset=\"UTF-8\">\r\n" + 
		 		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
		 		"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
		 		"    <title>Document</title>\r\n" + 
		 		"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\"\r\n" + 
		 		"    crossorigin=\"anonymous\">\r\n" + 
		 		"<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\r\n" + 
		 		"    crossorigin=\"anonymous\"></script>\r\n" + 
		 		"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\"\r\n" + 
		 		"    crossorigin=\"anonymous\"></script>\r\n" + 
		 		"<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\" integrity=\"sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T\"\r\n" + 
		 		"    crossorigin=\"anonymous\"></script>\r\n" + 
		 		"</head>\r\n" + 
		 		"\r\n" + 
		 		"<body>\r\n" + 
		 		" \r\n" + 
		 		"\r\n" + 
		 		"<a href= \"trytwo\">Use the force to view species </a>"+
		 		"    <hr>\r\n" + 
		 		"    <h4>Leverage AJAX to View Starships</h4>\r\n" + 
		 		"    <input type=\"number\" id=\"swID\" class=\"form-control col-4\">\r\n" + 
		 		"    <h5>Welcome to the force <span id=\"output\"></span></h6>\r\n" + 
		 		"    <button id=\"go\" class=\"btn btn-primary\">Go!</button>\r\n" + 
		 		"\r\n" + 
		 		"\r\n" + 
		 		"    <script>\r\n" + 
		 		"        window.onload = function(){\r\n" + 
		 		"            $('#go').on('click', useTheForce);\r\n" + 
		 		"        }\r\n" + 
		 		"        function useTheForce(){\r\n" + 
		 		"      \r\n" + 
		 		"            var xhr = new XMLHttpRequest();\r\n" + 
		 		"     \r\n" + 
		 		"            xhr.onreadystatechange = function(){\r\n" + 
		 		"                console.log(xhr.readyState);\r\n" + 
		 		"                if(xhr.readyState == 4 && xhr.status == 200 ){\r\n" + 
		 		"                    console.log(xhr.responseText);\r\n" + 
		 		"                    globalperson = JSON.parse(xhr.responseText);\r\n" + 
		 		"                    $('#output').html(JSON.parse(xhr.responseText).name);\r\n" + 
		 		"                }\r\n" + 
		 		"            }\r\n" + 
		 		"          \r\n" + 
		 		"            var id = $('#swID').val();\r\n" + 
		 		"            var url = `https://swapi.co/api/starships/${id}/`;\r\n" + 
		 		"            	//`https://swapi.co/api/people/${id}/`;\r\n" + 
		 		"            	//`https://swapi.co/api/vehicles/${id}/`;\r\n" + 
		 		"            	\r\n" + 
		 		"            xhr.open('GET', url, true);\r\n" + 
		 		"   \r\n" + 
		 		"            xhr.send(); \r\n" + 
		 		"            console.log(\"SENT REQUEST \" + xhr.responseText); \r\n" + 
		 		"            }\r\n" + 
		 		"    </script>\r\n" + 
		 		"</body>\r\n" + 
		 		"</html>");
		}
	}
	 

