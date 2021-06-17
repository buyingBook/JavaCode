<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 박유경
  Date: 2021-06-07
  Time: 오전 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>금오공과대학교 도서구매 시스템</title>
    <link href="../../../static/major/major.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../../../static/major/major.js"></script>

	<style>
 
		table{
			border: 1px solid; border-collapse: collapse; text-align: center;
		}

		th, td{ border: 1px solid; padding: 10px 5px;}

		th{background-color: rgba(7, 100, 100, 0); color: rgb(0, 0, 0);}

		/* 짝수줄만 배경색을 다르게 */

		td:nth-child(1){width: 40%}
		th{border-bottom: double rgb(0, 0, 0);}

		/* 직접 만들지 않았지만 그래서 보이지는 않지만 실제 */
		/* 테이블 안에 첫번째 자식은 tr이 아니라 tbody라는 녀석임 */
		table tr{color: rgb(0, 0, 0);}

	</style>


</head>
<body>
<jsp:include page= "layout/header.jsp"/>
<!-- 컨텐츠 -->
<section class = "mainPage">
    <div class = "mainPost">
        <div class = "optionContainer">
            <img src="../../img/main.jpg" width="100%">
        </div>
        <div class = "MainListWrapper1">
        <table border="1" width = "40%" style = "float:left; margin-left:10%;">
			<caption> 책 구매 게시판 </caption>
			<tr>
	            <th>번호</th>
	            <th>제목</th>
	            <th>글쓴이</th>
	            <th>가격</th>
	        </tr>
	        <c:forEach var="row" items="${books}">
	        <tr>
	    
	            <td>${row.bookNum}</td>
	            <td>${row.bookName}</td>
	            <td>${row.bookAuthor}</td>
	            <td>${row.bookPrice}</td>
	        </tr>
        </c:forEach>
    	</table>
        </div>
		<div class = "MainListWrapper2">
			<table border="1" width = "40%" style = "float:right; margin-right:10%;">
		        <caption> 질의응답 게시판 </caption>
				<tr>
		            <th>번호</th>
		            <th>제목</th>
		        </tr>
		      
		        <c:forEach var="row" items="${boards}">
		        <tr>
		            <td>${row.id}</td>
		            <td>${row.title}</td>
		        </tr>
	        </c:forEach>
	    </table>
		</div>

</section>
</body>
</html>
