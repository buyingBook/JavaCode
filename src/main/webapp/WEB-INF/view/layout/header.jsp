<%--
  Created by IntelliJ IDEA.
  User: 박유경
  Date: 2021-06-07
  Time: 오전 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>금오공과대학교 도서 구매 시스템</title>
    <link href="../../../static/layout.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../../../static/layout.js"></script>
</head>
<body>
<!-- 헤더 (사이트 설명) -->
<%--<header>--%>
    <div id = "logoHeader">
        <img id="logoImg" src="../../../img/logo.png" width="170px">
        <h2><strong>도서 구매 사이트</strong></h2>
    </div>

    <!-- 매뉴바 -->
    <nav id ="menuTrigger"  onclick="openNav()">
    <span style="font-size:30px;cursor:pointer">&#9776;
        <img id="logo" src="../../../img/logo.png" width="170px">
        <h4 style="font-size:20px;display: inline;"><strong> 도서 구매 사이트</strong></h4>
    </span>
    </nav>

    <nav id = "menuBar" class = "menu">
        <a href="javascript:void(0)" id="closebtn" class="closebtn" onclick="closeNav()">&times;</a>
        <ul>
            <li><a href="#"><h3>메인화면</h3></a></li>
            <li><a href="/front/book/list"><h3>책 구매</h3></a></li>
            <li><a href="#"><h3>질의응답</h3></a></li>
            <li><a href="#"><h3>마이페이지</h3></a></li>
        </ul>
    </nav>
<%--</header>--%>
<script>
    const close = document.getElementById("closebtn");
    if(matchMedia("(min-width: 768px)").matches) {
        close.style.visibility = "hidden";
    } else {
        close.style.visibility = "visible";
    }
</script>
</body>
</html>
