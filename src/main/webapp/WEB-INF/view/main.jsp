<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			display: flex;
			flex-direction: row;
			flex-wrap: wrap;
			width: 90%;
			height: auto;
			justify-content: space-around;
			align-content: center;
		}

		table{
			border: 1px solid; border-collapse: collapse; text-align: center;
		}

		th, td{ border: 1px solid; padding: 10px 5px;}

		th{background-color: rgba(7, 100, 100, 0); color: rgb(0, 0, 0);}

		/* 짝수줄만 배경색을 다르게 */

		td:nth-child(1){width: 40%}
		th{border-bottom: double rgb(0, 0, 0);}

		/* 직접 만들지 않았지만 그래서 보이지는 않지만 실제 */
		/* 테이블 안에 첫번째 자식은 tr이 아니라 tbody라는 녀석임 */
		table tr{color: rgb(0, 0, 0);}

		.bookRecommend, .board {
			display: flex;
			flex-direction: column;
		}

		.slideshow-container {
			margin-bottom: 2rem;
		}

		@media (min-width: 768px) {
			.mainSection {
				padding-top: 1%;
			}

			.mainContainer {
				justify-items: center;
			}

			.mainContainer, .mainContents {
				width: 70%;
			}
		}
		.mySlides {display: none;}
		img {vertical-align: middle;}
		.accdiv {display: inline; float: right; margin-right: 600px; margin-top: -500px;}
		/* Slideshow container */
		.slideshow-container {
			display: inline-block;
			max-width: 1000px;
			position: relative;
		}

		/* Next & previous buttons */
		.prev, .next {
			cursor: pointer;
			position: absolute;
			top: 50%;
			width: auto;
			padding: 16px;
			margin-top: -22px;
			color: white;
			font-weight: bold;
			font-size: 18px;
			transition: 0.6s ease;
			border-radius: 0 3px 3px 0;
			user-select: none;
		}

		.prev {
			left: 0;
		}
		/* Position the "next button" to the right */
		.next {
			right: 0;
			border-radius: 3px 0 0 3px;
		}

		/* On hover, add a black background color with a little bit see-through */
		.prev, .next {
			background-color: rgba(0,0,0,0.8);
		}
	</style>
</head>
<body>
<jsp:include page= "layout/header.jsp"/>
<!-- 컨텐츠 -->
<section class = "mainSection">
	<img src="../../img/main.jpg" width="100%">
	<div class = "mainContainer">
		<div class = "bookRecommend">
			<h3>이런 책은 어떠세요?</h3>
			<div class="slideshow-container">
				<c:forEach var="book" items="${books}">
					<div class="mySlides fade">
						<img src="${book.imageURL}" style="width:100%">
						<div class="text">
							<div class = "name"><strong>${book.bookName}</strong></div>
							<div class = "maker">
								${book.bookAuthor} 저 | ${book.bookPub}
							</div>
						</div>
						<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
						<a class="next" onclick="plusSlides(1)">&#10095;</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="board">
			<h3>HOT</h3>
			<table display="block" width = "100%">
				<tr>
					<th>번호</th>
					<th>제목</th>
				</tr>
				<c:forEach var="board" items="${boards}">
					<tr>
						<td>${board.id}</td>
						<td>${board.title}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</section>
<script>
	// Carousel
	var slideIndex = 1;
	showSlides(slideIndex);

	function plusSlides(n) {
		showSlides(slideIndex += n);
	}

	function currentSlide(n) {
		showSlides(slideIndex = n);
	}

	function showSlides(n) {
		var i;
		var slides = document.getElementsByClassName("mySlides");
		var dots = document.getElementsByClassName("dot");
		if (n > slides.length) {slideIndex = 1}
		if (n < 1) {slideIndex = slides.length}
		for (i = 0; i < slides.length; i++) {
			slides[i].style.display = "none";
		}
		for (i = 0; i < dots.length; i++) {
			dots[i].className = dots[i].className.replace(" active", "");
		}
		slides[slideIndex-1].style.display = "block";
		dots[slideIndex-1].className += " active";
	}
</script>
</body>
</html>
