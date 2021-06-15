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
        <div class = "majorListWrapper">
            <table class = "majorList">
                <c:forEach var="major" items="${majors}">
                    <tr>
                        <td class = "image">
                            <img src="${major.imageURL}" width="100%">
                        </td>
                        <td class = "info">
                            <div class = "name"><a href="detail?id=${major.majorId}"><strong>${major.majorName}</strong></a></div>
                        </td>
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
    </div>
</section>
</body>
</html>
