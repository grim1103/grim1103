<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="stylesheet" href="css/style.css" />
<meta charset="UTF-8">
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>

<style>
h1 {
	padding: 50px 0;
	font-weight: 400;
	text-align: center;
}

p {
	margin: 0 0 20px;
	line-height: 1.5;
}

.main {
	min-width: 320px;
	max-width: 850px;
	padding: 50px;
	margin: 0 auto;
	background: #ffffff;
	max-width: 850px;
}

section {
	display: none;
	padding: 20px 0 0;
	border-top: 1px solid #ddd;
}

/*라디오버튼 숨김*/
#tab1, #tab2 {
	display: none;
}

label {
	display: inline-block;
	margin: 0 0 -1px;
	padding: 15px 25px;
	font-weight: 600;
	text-align: center;
	color: #bbb;
	border: 1px solid transparent;
}

label:hover {
	color: #2e9cdf;
	cursor: pointer;
}

/*input 클릭시, label 스타일*/
input:checked+label {
	color: #555;
	border: 1px solid #ddd;
	border-top: 2px solid #2e9cdf;
	border-bottom: 1px solid #ffffff;
}

#tab1:checked ~ #content1, #tab2:checked ~ #content2 {
	display: block;
}

Button {
	background-color: transparent;
	border: 0px none;
}

.btnImage {
	background-color: transparent;
	vertical-align: middle;
	background: url("loginButton.png") no-repeat;
	border: 0px none;
	cursor: pointer;
	clear: none;
	float: none;
}
#naverIdLogin{
	text-align: center;
}
/* login_div{
	position:fixed;
} */
</style>
<link rel="stylesheet" href="css/style.css" />
<title>Login</title>
</head>
<body>
	<div id="container">
		<div id="login_div"><jsp:include page="/header.jsp"></jsp:include></div>
		<br> <br> <br> <br>
		<div class="main">
			<form name="loginform" action="MemberLoginAction.mo" method="post">
				<br>
				<center>
					<table width=400px;>
						<tr>
							<td colspan="2" align="center" style="font-size: 20pt;"><b>LOGIN</b>
							</td>
						</tr>
						<tr>
							<td align=center style="font-size: 12pt;">I D</td>
							<td><input type="text" name="id" id="id"
								style="width: 250px; height: 30px; font-size: 10pt;"></td>
							<td rowspan="2">
								<div>
									<button type="submit" value="LOGIN">
										<img class="btnImage" src="image/loginButton.png">
									</button>
								</div>
							</td>
						</tr>
						<tr>
							<td align=center style="font-size: 12pt;">PASS</td>
							<td><input type="password" name="pw" id="pw"
								style="width: 250px; height: 30px; font-size: 10pt;"></td>
						</tr>

					</table>
					<table>
						<tr>
							<td>
								<div>
									<a href="main.jsp">아이디 찾기</a>
								</div>
							</td>
							<td>
								<div>
									<a href="main.jsp">비밀번호 찾기</a>
								</div>
							</td>
						</tr>
					</table>
				</center>
			</form>
		</div>
	</div>
	
	
	<div id="naverIdLogin"></div>
	
	<script type="text/javascript">
		var naverLogin = new naver.LoginWithNaverId(
			{
				clientId:"817YOaY39wvn8CRMKIfT",
				callbackUrl:"http://localhost/Shopping/callback.jsp",
				isPopup: false,
				loginButton: {color: "green", type: 3, height: 60} 
			}
		);
	
		
		naverLogin.init();
</script>
</body>
</html>