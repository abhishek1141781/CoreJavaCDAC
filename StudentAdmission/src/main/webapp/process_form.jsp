<%@page import="pojos.Course"%>
<%@page import="java.time.Period"%>
<%@page import="java.time.LocalDate"%>
<%@page import="pojos.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ApplicationProcessingForm</title>
</head>
<body>
<% 
//create student object : by rading and parsing
String firstName = request.getParameter("fn");
String lastName = request.getParameter("ln");
Course courseName =Course.valueOf(request.getParameter("course").toUpperCase());
int marks =Integer.parseInt(request.getParameter("score"));
LocalDate dob = LocalDate.parse(request.getParameter("Dob"));
Student stud = new Student(firstName,lastName,courseName,marks,dob);

//valdiate age and score
int ageInYrs = Period.between(dob,LocalDate.now()).getYears();

if(ageInYrs<30 && marks>=courseName.getMinScore())
	{stud.setAdmissionStatus(true);
	//save student 
session.setAttribute("studentDetails", stud);
response.sendRedirect("result.jsp");
}

%>
</body>
</html>