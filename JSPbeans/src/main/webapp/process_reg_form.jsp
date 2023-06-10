<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="voter" class="bean.VoterDetails" scope="session"/>
<jsp:setProperty property="*" name="voter"/>
<body>

	<%-- <h4>registration status : </h4>  --%>
	<c:redirect url="${sessionScope.voter.registerVoter()}.jsp" />
</body>
</html>