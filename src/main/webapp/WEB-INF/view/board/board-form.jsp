<!-- 필터를 적용해도 한글 깨짐이 있을 경우
charset과 pageEncoding을 utf-8로 변경 -->

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
</head>
<body>
<form action="/front/board/write" method="post">
    <%--@declare id="uname"--%>
    <label for="uname"><b>작성자</b></label>
    <input type="text" placeholder="작성자" name="writer">
    <br>
    <label for="uname"><b>제목</b></label>
    <input type="text" placeholder="제목을 입력하세요" name="title">
    <br>
    <label for="uname"><b>내용</b></label>
    <input type="text" placeholder="내용을 입력하세요" name="contents">

    <button type="submit">등록</button>
</form>
</body>
</html>