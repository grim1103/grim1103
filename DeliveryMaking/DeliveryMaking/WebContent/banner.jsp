
﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
#slider {
  width: 1250px;
  height: 680px;
  overflow: hidden;
}

.slide {
  width: 1250px;
  height: 680px;
  float: left;
  position: relative;
}

#slide-holder {
  width: 600%;
  position: relative;
  left: 0;
  -webkit-animation: scroller 10s infinite;
          animation: scroller 60s infinite;
}

@-webkit-keyframes scroller {
   0% {
    -webkit-transform: translateX(0);
            transform: translateX(0);
  }
  12% {
    -webkit-transform: translateX(-1250px);
            transform: translateX(-1250px);
  }
  24% {
    -webkit-transform: translateX(-2500px);
            transform: translateX(-2500px);
  }
  36% {
    -webkit-transform: translateX(-3750px);
            transform: translateX(-3750px);
  }
  48% {
    -webkit-transform: translateX(-5000px);
            transform: translateX(-5000px);
  }
  60% {
    -webkit-transform: translateX(-6250px);
            transform: translateX(-6250px);
  }
  72% {
    -webkit-transform: translateX(-5000px);
            transform: translateX(-5000px);
  }
  84% {
    -webkit-transform: translateX(-3750px);
            transform: translateX(-3750px);
  }
  100% {
    -webkit-transform: translateX(0px);
            transform: translateX(0px);
  }
}

@keyframes scroller {
  0% {
    -webkit-transform: translateX(0);
            transform: translateX(0);
  }
  12% {
    -webkit-transform: translateX(-1250px);
            transform: translateX(-1250px);
  }
  24% {
    -webkit-transform: translateX(-2500px);
            transform: translateX(-2500px);
  }
  36% {
    -webkit-transform: translateX(-3750px);
            transform: translateX(-3750px);
  }
  48% {
    -webkit-transform: translateX(-5000px);
            transform: translateX(-5000px);
  }
  60% {
    -webkit-transform: translateX(-6250px);
            transform: translateX(-6250px);
  }
  72% {
    -webkit-transform: translateX(-5000px);
            transform: translateX(-5000px);
  }
  84% {
    -webkit-transform: translateX(-3750px);
            transform: translateX(-3750px);
  }
  100% {
    -webkit-transform: translateX(0px);
            transform: translateX(0px);
  }
}
body {
  font-family: sans-serif;
}

#slider {
  margin: 0 auto;
}

 .slide:nth-child(1) {
  background: #c69;
}

.slide:nth-child(2) {
  background: wheat;
}

.slide:nth-child(3) {
  background: #eee;
}
.slide:nth-child(4) {
  background: #eee;
}
.slide:nth-child(5) {
  background: #eee;
}
.slide:nth-child(6) {
  background: #eee;
}
.slide:nth-child(7) {
  background: #eee;
}

</style>
<meta charset="UTF-8">
<title>Banner</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>

	<!-- 배너사진 -->
	<div class="banner">
		<div id="slider">
			<div id="slide-holder">
			
				<div class="slide">
					<img src="image/M1.jpg" width="1250px" height="680px"/>
				</div>
				
				<div class="slide">
					<img src="image/hori4.jpg" width="1250px" height="680px"/>
				</div>
				
				<div class="slide">
					<img src="image/M3.jpg" width="1250px" height="680px"/>
				</div>
				
				<div class="slide">
					<img src="image/hori6.jpg" width="1250px" height="680px"/>
				</div> 
				
				<div class="slide" >
					<img src="image/M5.jpg" width="1250px" height="680px"/>
					</div>
					
				<div class="slide" >
					<img src="image/hori5.jpg" width="1250px" height="680px"/>
				</div>
				
			</div>
		</div>
</body>
