<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>금오공과대학교 도서구매 시스템</title>
    <link href="../../../static/major.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../../../static/major.js"></script>
</head>
<body>
<jsp:include page= "../layout/header.jsp"/>
<!-- 컨텐츠 -->
<section class = "mainSection">
    <div class = "mainContainer">
        <div class = "optionContainer">
            <form id ="search" action="search">
                <select id = "majors" name="major">
                    <option value="all">전체</option>
                    <option value="cse">컴퓨터소프트웨어공학과</option>
                    <option value="civil">토목공학과</option>
                    <option value="chemistry">응용화학과</option>
                    <option value="business">경영학과</option>
                </select>
                <select id = "grade" name="grade">
                    <option value="all">전체</option>
                    <option value="1">1학년</option>
                    <option value="2">2학년</option>
                    <option value="3">3학년</option>
                    <option value="4">4학년</option>
                </select>
                <button type="submit" id="searchBtn">검색</button>
            </form>
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
            <c:if test="${pageMaker.prev}">
                <a href="search/page?idx=${pageMaker.startPage-1}">〈</a>
            </c:if>
            <c:forEach var="num" varStatus="status" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                <a href="search/page?idx=${status.index}">${status.index}</a>
            </c:forEach>
            <c:if test="${pageMaker.next}">
                <a href="search/page?idx=${pageMaker.endPage+1}">〉</a>
            </c:if>
        </div>
    </div>
</section>
</body>
</html>
