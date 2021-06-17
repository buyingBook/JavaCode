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
    <link href="../../static/major.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../../static/major.js"></script>
</head>
<body>
<jsp:include page= "layout/header.jsp"/>
<!-- 컨텐츠 -->
<section class = "mainPage">
    <div class = "mainPost">
        <div class = "optionContainer">
            <img src="../../img/main.jpg" width="100%">
        </div>
        <div class = "bookListWrapper">
        <table border="1">
	      	 <tr>
	            <th>번호</th>
	            <th>제목</th>
	            <th>글쓴이</th>
	            <th>가격</th>
	        </tr>
        <!-- forEach 문은 리스트 객체 타입을 꺼낼때 많이 활용된다. -->
	        <c:forEach var="row" items="${list}">
	        <tr>
	            <!-- 컨트롤러에서 넘겨준 list 모델 객체를 쓰는 방법을 잘 익혀두자 -->
	            <td>${row.cid}</td>
	            <td>${row.bookName}</td>
	            <td>${row.bookAuthor}</td>
	            <td>${row.bookPrice}</td>
	<!--               <td>
	                 데이터 타입을 사용하는 방법 --
	              <fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
	            </td>
	            <td>${row.viewcnt}</td> -->
	        </tr>
        </c:forEach>
    	</table>
        </div>
			<table border="1">
		        <tr>
		            <th>번호</th>
		            <th>제목</th>
		        </tr>
		        <!-- forEach 문은 리스트 객체 타입을 꺼낼때 많이 활용된다. -->
		        <c:forEach var="row" items="${list}">
		        <tr>
		            <!-- 컨트롤러에서 넘겨준 list 모델 객체를 쓰는 방법을 잘 익혀두자 -->
		            <td>${row.bno}</td>
		            <td>${row.title}</td>
		<!--        <td>

		              <fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
		            </td>
		            <td>${row.viewcnt}</td> --> 
		        </tr>
	        </c:forEach>
	    </table>
    </div>
</section>
</body>
</html>
