<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>금오공과대학교 도서구매 시스템</title>
    <link href="../../../static/major/major.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page= "../layout/header.jsp"/>
<!-- 컨텐츠 -->
<section class = "mainSection">
    <div class = "mainContainer">
        <div class = "mainInfoContainer">
            <div id = "mainInfo">
                <div id = "name"><h3>HTML5 + CSS3 웹 표준의 정석</h3></div>
                <div id = "author"><div id = "authorName">고경희</div> 저 | </div>
                <div id = "publishing">이지스퍼블리싱</div>
            </div>
            <img id = "bookImg" src="../../../img/htmlcssBook1.jpg" height="400rem">
            <div id = "money"><h3>22,500원</h3></div>
        </div>

        <div id = "line"><hr width="90%" visibility="visible"></div>
        <div class = "subInfoContainer">
            <article id = "detailInfo">

                <div id = "recommend">[추천 대상]<br><br></div>
                <div id = "major">학과 > <strong>컴퓨터소프트웨어공학과</strong><br></div>
                <div id = "subject">과목 > <strong>웹프로그래밍</strong><br></div>
                <div id = "object">대상 > <strong>3학년</strong><br></div>

            </article>
            <div><hr visibility="visible"></div>
            <section id = "purchase">
                <li id = "choiceZone">
                    <button id = "minusbtn">-</button>
                    <input id = "cnt" value = 1>
                    <button id = "plusbtn">+</button>
                    <p id = "totalMoney">22,500</p>
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
