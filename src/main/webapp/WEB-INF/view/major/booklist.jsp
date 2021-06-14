<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>금오공과대학교 도서구매 시스템</title>
    <link href="../../../static/major/major.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../../../static/major/major.js"></script>
</head>
<body>
<jsp:include page= "../layout/header.jsp"/>
<!-- 컨텐츠 -->
<section class = "mainSection">
    <div class = "mainContainer">
        <div class = "optionContainer">
            <select id = "majors">
                <option value="all" selected>전체</option>
                <option value="cse">컴퓨터소프트웨어공학과</option>
                <option value="machine">토목공학과</option>
                <option value="chemistry">응용화학과</option>
                <option value="business">경영학과</option>
            </select>
            <select id = "grade">
                <option value="all" selected>전체</option>
                <option value="freshman">1학년</option>
                <option value="sophomore">2학년</option>
                <option value="junior">3학년</option>
                <option value="senior">4학년</option>
            </select>
        </div>
        <div class = "bookListWrapper">
            <table class = "bookList">
                <c:forEach var="book" items="${books}">
                <tr>
                    <td class = "image">
                        <img src="${book.imageURL}" width="100%">
                    </td>
                    <td class = "info">
                        <div class = "name"><a href="detail?id=${book.bookNum}"><strong>${book.bookName}</strong></a></div>
                        <div class = "maker" style="display: block;">
                            <div class = "author" style="display: inline;">${book.bookAuthor}</div> 저 |
                            <div class = "publishing">${book.bookPub}</div>
                        </div>
                    </td>
                    <td class = "price">${book.bookPrice}</td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <div class = "pagingContainer">
            <a href="#">《</a>
            <a href="#">〈</a>
            <a class = "select" href="#">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">〉</a>
            <a href="#">》</a>
        </div>
    </div>
</section>
</body>
</html>
