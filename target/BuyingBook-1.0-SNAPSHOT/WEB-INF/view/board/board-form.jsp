<!-- 필터를 적용해도 한글 깨짐이 있을 경우
charset과 pageEncoding을 utf-8로 변경 -->

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <link href="../../../static/layout.css" rel="stylesheet" type="text/css">
    <style>
        .enterTable {
            text-align: center;
        }
        form label {
            text-align: left;
            padding-right : 20px;
            padding-bottom : 30px;
            line-height : 25px;
            width : auto;
        }

        form button {
            width : 100px;
            height : 30px;
            background-color : #0099ff;
            color: white;
        }

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
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
<form action="/front/board/write" method="post">
    <%--@declare id="uname"--%>
    <div class="enterTable">
        <br>
        <br>
        <h1> 게시글 작성 </h1>
        <br>
        <br>
        <label for="uname" style="width:50px"><b>제목  </b></label>
        <input type="text" placeholder="제목을 입력하세요" name="title" style="width:70%; height : 30px;">
        <br>
        <br>
        <label for="uname" style="width:50px"><b>내용  </b></label>
        <input type="text" placeholder="내용을 입력하세요" name="contents" style="width:70%; height:300px;">
        <br>
        <br>
        <label for="uname" style="width:50px"><b>작성자</b></label>
        <input type="text" placeholder="작성자" name="writer" style="width:70%; height:30px;">
        <br>
        <br>
        <button type="submit">등록</button>
    </div>

</form>
</body>
</html>