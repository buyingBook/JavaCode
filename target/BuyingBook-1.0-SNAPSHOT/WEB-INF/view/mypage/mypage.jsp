<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
 	
 	<link href="../../../static/mypage.css" rel="stylesheet" type="text/css">
    <style>
        body{
            font-family: 'Nanum Gothic', 'serif';
        }

        .menu_container  {
            display:none;
            position: relative;
            padding-left: 10px;
            height: 60px;
            background-color: #0099ff
        }


        .menu_container ul li{
            position: relative;
            top: 20px;
            list-style: none;
            color: white;
            float: left;
            line-height: 25px;
            vertical-align: middle;
            text-align: center;

        }

        .menu_link{
            text-decoration:none;
            color: white;
            display: block;
            width: 150px;
            font-size: 20px;
            font-weight: bold;
        }

        .menu_link:hover{
            color: yellowgreen;
        }

        .sidenav {
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

        .sidenav a {
            padding: 8px 8px 8px 32px;
            text-decoration: none;
            font-size: 25px;
            color: white;
            display: block;
            transition: 0.3s;
        }

        .sidenav a:hover {
            color: yellowgreen;
        }

        .sidenav .closebtn {
            position: absolute;
            top: 0;
            right: 25px;
            font-size: 36px;
            margin-left: 50px;
        }

        .sub_menu{
            display:block;
            padding: 10px;
            margin: 10px auto;
            border: 2px  black;
            color: white;
            background-color: #0099ff
        }

        /* 메인 컨텐츠 */
        .main_container{
            position: relative;
            max-width: 1500px;
            height: 100%;
            margin: 0 auto;
        }

        /* 2줄로 구성, 모바일은 1줄, PC2줄*/
        .main_column{
            float: none;
            width: 100%;
        }

        /* 메뉴 박스 */
        .main_box{
            min-height: 250px;
            margin: 16px 8px;
            padding: 32px 29px 30px;
            text-align: left;
            border: 1px solid #0099ffbd;
            border-radius: 2px;
        }

        /* 박스 제목*/
        .main_box_header{
            font-size: 25px;
            font-weight: 900;
            line-height: 22px;
            padding-bottom: 2px;
            color: #333;
        }
        /* 박스 내용*/
        .main_box_content{
            min-height: 150px;
            padding-top: 30px;
            color: #333;
        }

        /* 아이디: 같은 소제목*/
        .main_box_content dt{
            font-size: 15px;
            font-weight: 700;
            float: left;
            width: 40%;
            padding-bottom: 10px;
            letter-spacing: -1px;
            color: #333;
        }

        /*소제목 내용 */
        .main_box_content dd{
            font-size: 14px;
            line-height: 21px;
            overflow: hidden;
            padding-bottom: 10px;
            white-space: nowrap;
            text-overflow: ellipsis;
            word-break: keep-all;
            color: #666;
        }

        /* 구매내역 또는 장바구니*/
        .shopping_basket{
            padding: 12px 0;
            border-bottom: 1px solid #e8e8e8;
            list-style: none;
        }

        /* 구매내역 , 장바구니 품목1개 */
        .shopping_basket_content{
            position: relative;
            display: table;
            padding: 12px 0;
            table-layout: fixed;
            width: 100%;
        }

        /* 구매내역 , 장바구니 이미지*/
        .shopping_basket_img{
            position: relative;
            display: table-cell;
            width: 120px;
        }

        /* 구매내역 , 장바구니 정보*/
        .shopping_basket_info{
            display: table-cell;
            padding: 0 20px 0 20px;
            vertical-align: middle;
        }


        /* 가로 768, 세로 1024 변형 */


        @media  (min-width: 768px)  {
            .menu_container{
                display:block;
                position: relative;
                height: 70px;
                margin: 10px auto;
            }

            .sub_menu{
                display: none;
            }

            .main_column{
                float: left;
                width: 50%;
            }

            .main_box{
                position: relative;
                max-width: 720px;
            }
        }
    </style>
</head>
<body>
<jsp:include page= "../layout/header.jsp"/>
	<form action="/front/mypage/mypage" method="post">
    <div class="main_container">
      <div class ="main_column">
        <div class="main_box">
          <div class="main_box_header">내정보</div>
          <div class="main_box_content">
          <dl>
            <dt>성명</dt>
            <dd>${member.memberName}</dd>
            <dt>ID</dt>
            <dd>${member.memberId}</dd>
            <dt>PWD</dt>
            <dd>${member.memberPwd}</dd>
            <dt>학과</dt>
            <dd>${member.memberMajor}</dd>
            <dt>학번</dt>
            <dd>${member.memberNo}</dd>
            <dt>학년</dt>
            <dd>${member.memberYear}</dd>
          </dl>
          
          </div>
        </div>
	
        <div class="main_box">
          <div class="main_box_header">구매 내역</div>
          <div class="main_box_content">

			
			<c:forEach var="purchaseList" items="${purchaseLists}">
			
            <ul class="shopping_basket">
              <li class="shopping_basket_content">
                <div class="shopping_basket_img"><img src="${purchaseList.imageURL}"  width="120" height="120"></div>
                <div class="shopping_basket_info">
             	 	<dl>
					 <dt>도서 제목</dt>
                 	 <dd>${purchaseList.bookName}</dd>
                 	 <dt>구매 날짜</dt>
                 	 <dd>${purchaseList.buyDate}</dd>
                	 <dt>도서 가격 (원)</dt>
                 	 <dd>${purchaseList.bookPrice}</dd>
                 	 <dt>저자</dt>
                 	 <dd>${purchaseList.bookAuthor}</dd>
					</dl>
                </div>
              </li>
            </ul>
            
            </c:forEach>
            
		</div>
      </div>  
     </div>
      <div class ="main_column">

         <div class="main_box">
          <div class="main_box_header">장바구니</div>
          <div class="main_box_content">
          
          <c:forEach var="shoppingList" items="${shoppingLists}">
          
             <ul class="shopping_basket">
              <li class="shopping_basket_content">
                <div class="shopping_basket_img"><img src="${shoppingList.imageURL}"  width="120" height="120"></div>
                <div class="shopping_basket_info">
                	<dl>
                  <dt>도서 제목</dt>
                  <dd>${shoppingList.bookName}</dd>
                  <dt>도서 가격 (원)</dt>
               	  <dd>${shoppingList.bookPrice}</dd>
               	  </dl>
                </div>
              </li>
            </ul>
            
          </c:forEach>
         
          </div>
        </div>

        <div class="main_box">
          <div class="main_box_header">내가 쓴 글</div>
          <div class="main_box_content">
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
              <c:forEach var="writingList" items="${writingLists}">
                  <tr>
                      <td>${writingList.id}</td>
                      <td><a href="board/detail?id=${writingList.id}">${writingList.title}</a></td>
                      <td>${writingList.writer}</td>
                      <td>${writingList.regdate}</td>
                      <td>${writingList.hit}</td>
                  </tr>
              </c:forEach>
              </table>
          </div>
        </div>

      </div>
    </div>
	</form>
</body>
</html>