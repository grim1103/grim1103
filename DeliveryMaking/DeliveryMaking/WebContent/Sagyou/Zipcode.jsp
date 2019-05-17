<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	function execDaumPostcode(){
		new daum.Postcode({
			oncomplete : function(data){
				
				var test = data.postcode
				alert(test);
				
				var fullAddr = '';
				var extraAddr = '';
				
				if(data.userSelectedType ==='R'){
					fullAddr = data.roadAddress;
				}else{
					fullAddr = data.jibunAddress;
				}
				
				if(data.userSeletedType ==='R'){
					if(data.bname !== ''){
						extraAddt += data.bname;
					}
					if(data.buildingName !== ''){
						extraAddr += (extraAddr !== '' ? ',' +data.buildingName : data.buildingName);
					}
					
					fullAddr += (extraAddr !== '' ? ' ('+extraAddr+')':'');
				}
				
				document.getElementById('postcode').value = data.zonecode;
				document.getElementById('address').value = fullAddr;
				
				document.getElementById('address2').focus();
			}
		}).open();
	}
</script>
</head>
<body>
<div class = "fixed-item" id = "favorites">
</div>
<div class = "container-fluid">
	<div class = "row">
		<div class = "col-md-12">
			
		</div>
	</div>
</div>

</body>
</html>