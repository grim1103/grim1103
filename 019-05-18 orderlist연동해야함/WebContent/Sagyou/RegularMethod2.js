function execDaumPostcode(){
		new daum.Postcode({
			oncomplete : function(data){
				
				var test = data.postcode
				alert('(구)우편번호'+test);
				
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
				document.getElementById('address1').value = fullAddr;
				
				document.getElementById('address2').focus();
			}
		}).open();
	}

function call() {
	var id = document.getElementById("id");
	var pw = document.getElementById("pw");
	var checkpw = document.getElementById("checkpw");
	var email = document.getElementById("email");
	var jumin = document.getElementById("jumin");
	var name = document.getElementById("name");

	var checkedIdPw = /^[a-zA-Z0-9]{4,12}$/;
	var checkedEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	var mesage = "4~12자의 영문 대소문자와 숫자로만 입력";
	
	
	// 아이디 체크
	if(id.value ==""){
		alert("아이디를 입력해 주세여");
		return false;
	}
	
	if (checkedIdPw.test(id.value)) {
		
	}else{
		alert("아이디는 "+mesage);
		id.focus();
		return false;
		
	}
	
	
	// 비밀번호 체크
	
	if(pw.value == ""){
		alert("비밀번호를 입력해 주세여");
		return false;
	}
	
	if(id.value == pw.value){
		alert("아이디랑 비밀번호랑 같습니다");
		pw.value = "";
		return false;
	}
	
	if (checkedIdPw.test(pw.value)) {
		
	}else{
		alert("비밀번호는 "+mesage);
		pw.focus();
		return false;
	}
	
	
	// 비밀번호 확인
	if (checkpw.value == pw.value) {
		
	}else{
		alert("비밀번호가 일치하지 않습니다 다시 입력해 주세요");
		pw.value = "";
		pw.focus();
		return false;
	}

	// 이메일 체크
	if(email.value == ""){
		alert("이메일을 입력해 주세여");
		return false;
	}
	
	if (checkedEmail.test(email.value)) {

	}else{
		alert("이메일 형식이 잘못되었습니다 다시 입력해 주세요");
		email.focus();
		return false;
	}

	// 주민번호 체크
	if(jumin.value == ""){
		alert("주민번호를 입력해 주세여");
		return false;
	}

	
	// 취미체크
	if(!acount.inter[0].checked && !acount.inter[1].checked &&
			!acount.inter[2].checked && !acount.inter[3].checked &&
			!acount.inter[4].checked
			){
		alert("관심분야가 없습니다 선택해주세여");
		return false;
	}
	
	// 자기소개
	if(acount.intro.value==""){
		alert("자기소개가 없습니다 선택해주세여");
		return false;
	}
	
	return true;
}
// 주민번호 계산
function calcul(){
	var num1 = document.getElementById("jumin");
	var num2 = document.getElementById("jumin2");
	var arrNum1 = new Array();
	var arrNum2 = new Array();
	
	  for (var i=0; i<num1.value.length; i++) {
          arrNum1[i] = num1.value.charAt(i);
      } 

      for (var i=0; i<num2.value.length; i++) {
          arrNum2[i] = num2.value.charAt(i);
      } 

      var tempSum=0;

      for (var i=0; i<num1.value.length; i++) {
          tempSum += arrNum1[i] * (2+i);
      } 

      for (var i=0; i<num2.value.length-1; i++) {
          if(i>=2) {
              tempSum += arrNum2[i] * i;
          }
          else {
              tempSum += arrNum2[i] * (8+i);
          }
      }

    if((11-(tempSum%11))%10!=arrNum2[6]) {
        alert("올바른 주민번호가 아닙니다.");
        num1.value = "";
        num2.value = "";
        num1.focus();
        return false;
    }else{
    	//생년월일 자동입력
    	//1234561234567
        //0123456789

    	var jumin = num1.value;
    	var jumin2 = num2.value;
    	
    	var arr2 = Array.from(jumin2);

    	var first2 = {};
    	
    	for(var i =0;i<arr2.length;i++){
    		first2["arr"+i]  = arr2[i];
    	}
    	
    	if(first2.arr0 ==1 || first2.arr0 ==2){
    		var y = parseInt(jumin.substring(0,2));
    		var m = parseInt(jumin.substring(2,4));
    		var d = parseInt(jumin.substring(4,6));
    		acount.year.value = 1900+y;
    		acount.month.value = m;	
    		acount.day.value = d;	
    		
    	}else if(first2.arr0 ==3 || first2.arr0 ==4){
    		var y = parseInt(jumin.substring(0,2));
    		var m = parseInt(jumin.substring(2,4));
    		var d = parseInt(jumin.substring(4,6));
    		acount.year.value = 2000+y;
    		acount.month.value = m;	
    		acount.day.value = d;
    	}
    	return true;
    }
}


