<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<style>
/* body {
	color: #555;
	background: #eeeeee;
	margin: 0;
	padding: 0;
	box-sizing: border-box;
} */

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
}

section {
	display: none;
	padding: 20px 0 0;
	border-top: 1px solid #ddd;
}

/*라디오버튼 숨김*/
input {
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
</style>

<title>Document</title>
</head>
<body>



	<div id="container">
	<div><jsp:include page="header.jsp" flush="false"></jsp:include></div>
		<div class="main">


			<div>
				<div>
					<div>
					<br><br><br><br>
						<h2>
							<span>EVENT</span>
						</h2>
						
					</div>
					
					<div class="description">
						<div class="member ">

							<ul>



								<input id="tab1" type="radio" name="tabs" checked>
								<label for="tab1">TV CF</label>



								<input id="tab2" type="radio" name="tabs">
								<label for="tab2">MAXIM CHANNEL</label>


								<section id="content1">

				<center><div><a href="https://www.youtube.com/watch?v=QyWiK1tovOY"> 
				<img src="image/gongu.gif" width="800px" height="500px" /></a></div></center>					
				<br>				
				<center><div><a href="https://www.youtube.com/watch?v=QyWiK1tovOY"> 
				<img src="image/gian.gif" width="800px" height="500px" /></a></div></center>
				<br>
				
										
									


									
								</section>

								<section id="content2">
									MAXIM CHANNEL
									

										
								</section>
						</div>



						</div>
					</div>
				</div>
			</div>
		</div>
	
</body>
</html>