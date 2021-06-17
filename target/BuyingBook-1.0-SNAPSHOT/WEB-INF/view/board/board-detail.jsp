<%@page import="java.util.List"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Insert title here</title>
    <style>
        .mainSection {
            width: 100%;
            height: 100%;
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            justify-content: center;
        }

        .mainContainer {
            display: inherit;
            flex-direction: row;
            flex-wrap: wrap;
            width: 90%;
            height: auto;
            justify-content: center;
            align-content: center;
        }

        .mainContents {
            display: flex;
            flex-direction: column;
            width: 95%;
            margin-top: 1rem;
            align-items: center;
        }

        #title, #writer, #content {
            width: 100%;
        }

        #title {
            word-wrap: break-word;
            text-align: center;
            font-size: 2rem;
            font-weight: bold;
        }
        #writer {
            text-align: right;
        }

        #content {
            border: 1px solid #0099ff;
            word-wrap: break-word;
            display: block;
            margin-top: 1rem;
            text-align: start;
        }

        button {
            background-color: #0099ff;
            color: white;
            margin: 0.1rem;
        }

        #btnContainer {
            display: flex;
            flex-direction: row;
        }

        @media (min-width: 768px) {
            .mainSection {
                padding-top: 3%;
            }

            .mainContainer {
                justify-items: center;
            }

            .mainContainer, .mainContents {
                width: 70%;
            }
        }
    </style>
</head>
<body>
<jsp:include page= "../layout/header.jsp"/>
<section class = "mainSection">
    <div class = "mainContainer">
        <div class = "mainContents">
            <div id = "title">${target.title}</div>
            <div id = "writer">작성자: ${target.writer}</div>
            <div id = "content"><p>${target.contents}</p></div>
            <div id="btnContainer">
                <button onclick="location.href='list'">확인</button>
                <form action="/front/board/detail/delete?id=${target.id}" method="post">
                    <button type="submit">삭제</button>
                </form>
            </div>
        </div>
</section>
<br>
</body>
</html>