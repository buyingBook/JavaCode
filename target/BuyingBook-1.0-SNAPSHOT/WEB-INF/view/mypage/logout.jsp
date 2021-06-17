<html>
<head>
</head>
<body>
<%
    HttpSession userSession = request.getSession();
    userSession.invalidate();
%>
</body>
</html>
