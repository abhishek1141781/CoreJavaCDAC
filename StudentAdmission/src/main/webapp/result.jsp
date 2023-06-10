<%@page import="pojos.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Hello ${sessionScope.studentDetails.firstName}
		${sessionScope.studentDetails.lastName}</h4>

	<%
 	Student s =(Student)session.getAttribute("studentDetails");
 	if(s.isAdmissionStatus()){
 	%>
	<h4>Congratulations !!! You are admitted in COurse :
		${sessionScope.studentDetails.chosenCourse}</h4>
	<%
 	}else{
 	%>
	<h4>Sorry!! You are not admitted in course :
		${sessionScope.studentDetails.chosenCourse}</h4>
	<%
 	}
 	%>

</body>
</html>