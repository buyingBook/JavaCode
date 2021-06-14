<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>금오공과대학교 도서구매 시스템</title>
    <script type="text/javascript" src="../../../static/major.js"></script>
    <link href="../../../static/major.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page= "../layout/header.jsp"/>
<!-- 컨텐츠 -->
<section class = "mainSection">
    <div class = "mainContainer">
        <div class = "mainInfoContainer">
            <div id = "mainInfo">
                <div id = "name"><h3>${target.bookName}</h3></div>
                <div id = "author"><div id = "authorName">${target.bookAuthor}</div> 저 | </div>
                <div id = "publishing">${target.bookPub}</div>
            </div>
            <img id = "bookImg" src="${target.imageURL}" height="400rem">
            <div id = "money"><h3>${target.bookPrice}</h3></div>
        </div>

        <div id = "line"><hr width="90%" visibility="visible"></div>
        <div class = "subInfoContainer">
            <article id = "detailInfo">

                <div id = "recommend">[추천 대상]<br><br></div>
                <div id = "major">학과 > <strong>${target.majorName}</strong><br></div>
                <div id = "subject">과목 > <strong>${target.lectureName}</strong><br></div>
                <div id = "professor">교수 > <strong>${target.professor}</strong><br></div>
                <div id = "object">대상 > <strong>${target.grade}학년</strong><br></div>

            </article>
            <div><hr visibility="visible"></div>
            <section id = "purchase">
                <li id = "choiceZone">
                    <button id = "minusbtn" onclick="pushMinus()">-</button>
                    <input id = "cnt" value = 1>
                    <button id = "plusbtn" onclick="pushPlus()">+</button>
                    <p id = "totalMoney">${target.bookPrice}</p>
                </li>

                <div id = "control">
                    <button id = "purchaseBtn">구매하기</button>
                    <button id = "myCart">장바구니</button>
                </div>
            </section>
        </div>
    </div>
</section>
<script>
    const line = document.getElementById("line");
    if(matchMedia("(min-width: 768px)").matches) {
        line.style.visibility = "hidden";
    } else {
        line.style.visibility = "visible";
    }
</script>
</body>
</html>
