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
                <option value="machine">기계공학과</option>
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
                <tr>
                    <td class = "image">
                        <img src="../../../img/htmlcssBook1.jpg" width="100%">
                    </td>
                    <td class = "info">
                        <div class = "name"><strong>html5 + css3 웹 표준의 정석</strong></div>
                        <div class = "maker" style="display: block;">
                            <div class = "author" style="display: inline;">고경희</div> 저 |
                            <div class = "publishing">이지스퍼블리싱</div>
                        </div>
                    </td>
                    <td class = "price">25,000원</td>
                </tr>
                <tr>
                    <td class = "image">
                        <img src="../../../img/ooseBook1.jpg" width="100%">
                    </td>
                    <td class = "info">
                        <div class = "name"><strong>소프트웨어 공학 에센셜</strong></div>
                        <div class = "maker" style="display: block;">
                            <div class = "author" style="display: inline">윤청</div> 저 |
                            <div class = "publishing">생능출판</div>
                        </div>
                    </td>
                    <td class = "price">33,000원</td>
                </tr>
                <tr>
                    <td class = "image">
                        <img src="../../../img/openglBook1.jpg" width="100%">
                    </td>
                    <td class = "info">
                        <div class = "name"><strong>OpenGL로 배우는 3차원 컴퓨터 그래픽스</strong></div>
                        <div class = "maker" style="display: block;">
                            <div class = "author" style="display: inline">주우석</div> 저 |
                            <div class = "publishing">한빛아카데미</div>
                        </div>
                    </td>
                    <td class = "price">38,000원</td>
                </tr>
                <tr>
                    <td class = "image">
                        <img src="../../../img/absolutecppBook1.jpg" width="100%">
                    </td>
                    <td class = "info">
                        <div class = "name"><strong>객체지향 원리로 이해하는 Absolute C++</strong></div>
                        <div class = "maker" style="display: block;">
                            <div class = "author" style="display: inline">Walter Savich</div> 저 |
                            <div class = "publishing">퍼스트북</div>
                        </div>
                    </td>
                    <td class = "price">35,000원</td>
                </tr>
                <tr>
                    <td class = "image">
                        <img src="../../../img/dsjavaBook1.jpg" width="100%">
                    </td>
                    <td class = "info">
                        <div class = "name"><strong>자바와 함께하는 자료구조의 이해</strong></div>
                        <div class = "maker" style="display: block;">
                            <div class = "author" style="display: inline">양성봉</div> 저 |
                            <div class = "publishing">생능출판</div>
                        </div>
                    </td>
                    <td class = "price">25,000원</td>
                </tr>
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
