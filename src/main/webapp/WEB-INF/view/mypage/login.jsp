<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	
	body{
	background: #f5f6f7;
    margin:0;
	padding:0;
}

.main-container{
	width:100%;
	display:flex;
	flex-direction:column;
	align-items:center;
	margin-top: 21px;
}
.main-container .main-wrap{
	width:768px;
}
.main-container .main-wrap .logo-wrap{
	padding-top:55px;
	display:flex;	
	flex-direction: column;
	align-items: center;
}
.main-container .main-wrap .logo-wrap img
{
	width: 231px;
	height: 44px;
}

.login-input-section-wrap{
	padding-top: 60px;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.login-input-wrap{
	width: 465px;
	height :48px;
	border: solid 1px #0099ff;
	background: white;
}
.password-wrap{
	margin-top: 13px;
}
.login-input-wrap input{
	border: none;
	width:430px;
	margin-top: 10px;
	font-size: 14px;
	margin-left: 10px;
	height:30px;
}
.login-button-wrap {
	padding-top: 13px;
}
.login-button-wrap button{
	width: 465px;
	height :48px;
	font-size: 18px;
	background: #0099ff;
	color: white;
	border: solid 1px #0099ff;
}

@media  (min-width: 768px)  {
    
	
	.main-container .main-wrap{
		width:100%;
	}

	.main-container .main-wrap .logo-wrap{
	padding-top:100px;
	display:flex;	
	flex-direction: column;
	align-items: center;
	}

.main-container .main-wrap .logo-wrap img{
	width: auto;
	height: auto;
	}

}
	</style>
</head>
<body>
	<form action="/front/mypage/check" method="post">
		<div class="main-container">
			<div class="main-wrap">
				<header>
					<div class="logo-wrap">
						<img src="https://kmug.co.kr/data/file/design/data_logo_%EA%B8%88%EC%98%A4%EA%B3%B5%EB%8C%80.jpg">
					</div>
				</header>
				<section class="login-input-section-wrap">
				<div class="login-input-wrap">	
					<input placeholder="아이디" type="text" name="id" onfocus="myfocus(this)"/>
				</div>
				<div class="login-input-wrap password-wrap">	
					<input placeholder="비밀번호" type="password" name="pwd" onfocus="myfocus(this)"/>
				</div>
				<div class="login-button-wrap">
					<button type="submit">
						로그인
					</button>
					
				</div>
				</section>
			</div>
		</div>
	</form>
	<script>
		function myfocus(x) {
			x.style.background = "rgba(211,211,211,0.51)";
		}
	</script>
</body>
</html>