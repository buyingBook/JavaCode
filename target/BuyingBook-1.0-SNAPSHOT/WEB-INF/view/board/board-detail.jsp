<%@page import="java.util.List"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Insert title here</title>
</head>
<body>
<jsp:include page= "../layout/header.jsp"/>
<h1>제목: ${target.title}</h1>
<h4>작성자: ${target.writer}</h4>
<p>내용: ${target.contents}</p>


<form action="/front/board/detail/delete?id=${target.id}" method="post">
    <button type="submit">삭제</button>
</form>
<br>
</body>
</html>