<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: iris8
  Date: 2021-06-16
  Time: 오전 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>금오공과대학교 도서구매 시스템</title>
    <link href="../../../static/layout.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../layout/header.jsp"/>

<section class="mainSection">
    <div class="mainContainer">
        <div class = "mainInfoContainer">
            <div id="table">
                <form action="list" method="get" align="center">
                    <input type="text" name="serchText" /> <input type="submit" value="검색" />
                </form>
                <table width="auto" border="3" bordercolor="lightgray" align="center">
                    <thead>
                    <tr>
                        <td>no</td>
                        <td>제 목</td>
                        <td>글쓴이</td>
                        <td>작성일</td>
                        <td>조회수</td>

                    </tr>
                    </thead>
                    <c:forEach var="board" items="${boards}">
                        <tr>
                            <td>${board.id}</td>
                            <!--게시글 조회를 위한 href는 query string 사용, method = GET
                            href는 상대경로 사용 -> 현재경로 board/board-list, 요청경로 board/detail + request parameter -->
                            <td><a href="detail?id=${board.id}">${board.title}</a></td>
                            <td>${board.writer}</td>
                            <td>${board.regdate}</td>
                            <td>${board.hit}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div class = "pagingContainer">
                <c:if test="${pageMaker.prev}">
                    <a href="page?idx=${pageMaker.startPage-1}">〈</a>
                </c:if>
                <c:forEach var="num" varStatus="status" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                    <a href="page?idx=${status.index}">${status.index}</a>
                </c:forEach>
                <c:if test="${pageMaker.next}">
                    <a href="page?idx=${pageMaker.endPage+1}">〉</a>
                </c:if>
            </div>

            <form action="/front/board/write" method="get">
                <button type="submit">글쓰기</button>
            </form>

        </div>
    </div>
</section>
</body>
</html>
