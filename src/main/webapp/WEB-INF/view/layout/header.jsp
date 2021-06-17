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
    <style>
        @import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800');
        body {font-family: 'Nanum Gothic', 'serif';}

        #logoHeader {
            display: none;
            padding: 1rem;
        }

        .menu {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #0099ff;
            overflow-x: hidden;
            transition: 0.5s;
            padding-top: 60px;
        }

        .menu a {
            padding: 8px 8px 8px 32px;
            text-decoration: none;
            color: white;
            display: block;
            transition: 0.3s;
        }

        .menu ul li a :hover {
            color: black;
        }

        .closebtn {
            position: absolute;
            color: white;
            top: 0;
            right: 25px;
            font-size: 36px;
            margin-left: 50px;
        }

        #menuTrigger{
            display:block;
            padding: 10px;
            margin: 10px auto;
            border: 2px  black;
            color: white;
            background-color: #0099ff
        }


        #menuBar {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            color: white;
            background-color: #0099ff;
            overflow-x: hidden;
            transition: 0.5s;
            padding-top: 60px;
        }

        #menuBar li {
            list-style-type: none;
            color: white;
            margin: 0;
            padding: 0;
        }
        #menuBar a {
            text-decoration: none;
            display: block;
        }

        #menuBar li a {
            color: white;
        }

        footer {
            background-color: lightgrey;
            display: flex;
            flex-direction: row;
            justify-content: center;
        }

        @media (min-width: 768px) {

            #logoHeader {
                position: relative;
                display: block;
                padding: 1rem;
            }

            #logoHeader > h2 {
                display: inline;
                padding-left: 1rem;
            }


            #menuTrigger {
                display: none;
            }


            #menuBar {
                height: 4.7rem;
                width: 100%;
                padding: 0;
                display: block;
                position: relative;
            }

            #menuBar ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
            }

            #menuBar ul:after {
                content: '';
                display: block;
                clear: both;
            }

            #menuBar li {
                width: 25%;
                display: inline;
                text-align: center;
                color: white;
                float: left;
            }

            #menuBar li:hover {
                background: blue;
                color: white;
            }

            .menu ul li a :hover {
                color: white;
            }
        }
    </style>
    <script>
        function goToMain() {
            location = "/front/";
        }
    </script>
</head>
<body>
<!-- 헤더 (사이트 설명) -->
<%--<header>--%>
    <div id = "logoHeader">
        <img id="logoImg" src="../../../img/logo.png" width="170px">
        <h2><strong>도서 구매 사이트</strong></h2>
    </div>

    <!-- 매뉴바 -->
    <nav id ="menuTrigger"  onclick="openNav()" ondblclick="goToMain()">
    <span style="font-size:30px;cursor:pointer">&#9776;
        <img id="logo" src="../../../img/logo.png" width="170px">
        <h4 style="font-size:20px;display: inline;"><strong> 도서 구매 사이트</strong></h4>
    </span>
    </nav>

    <nav id = "menuBar" class = "menu">
        <a href="javascript:void(0)" id="closebtn" class="closebtn" onclick="closeNav()">&times;</a>
        <ul>
            <li><a href="/front/"><h3>메인화면</h3></a></li>
            <li><a href="/front/major/list"><h3>책 구매</h3></a></li>
            <li><a href="#"><h3>질의응답</h3></a></li>
            <li><a href="/front/mypage"><h3>마이페이지</h3></a></li>
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
