<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% 
		if(session.getAttribute("id") == null ) {
			out.println("<a href='/front/mypage'>�α���</a>");
		}
		else {
			out.println("<a href='/front/mypage'>����������</a>");
		}
	%>

</body>
</html>
