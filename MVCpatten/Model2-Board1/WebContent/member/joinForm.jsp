<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>joinForm.jsp</title>
<style type="text/css">

   
   body{
      background-image: url("./member/1313.jpg");
      background-repeat: no-repeat;
      background-size: cover;
      
   }
   
   
   
</style>

<script language="javascript">

function call() {
	var id = document.getElementById("member_id");
	var pw = document.getElementById("member_pw");
	var checkpw = document.getElementById("checkpw");
	var email = document.getElementById("member_email");
	var jumin = document.getElementById("member_jumin");
	var name = document.getElementById("member_name");

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
	var num1 = document.getElementById("member_num1");
	var num2 = document.getElementById("member_num2");
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
</script>

</head>
<body>

<form action="./MemberJoinAction.me" method = "post"  name="acount" onsubmit="return call()">
<center>
  <br><br><br><br><br>
     <b> <table border=1 style="background-color:transparent;"> 
         <tr>
            <td colspan = "2">
            <font size=10><center>Member Information</center> </font>
            </td>
         </tr>
         <tr>
            <td class = "atrr"  align=center> <font size=5> ID : </td> </font>
            <td class = "atrr1"><input type = "text" id = "member_id" name = "member_id" maxlength="12" style=" width:250pt; height:20pt; font-size:15pt; background-color:transparent; ">
                <span>4~12자리 영문 대소문자와 숫자로만 입력</span></td>
         </tr>
         <tr>
            <td class = "atrr" align=center> <font size=5> PASS : </td> </font>
            <td class = "atrr1"><input type = "password" id = "member_pw" name = "member_pw" maxlength="12" style=" width:250pt; height:20pt; font-size:15pt; background-color:transparent;">
                <span>4~12자리 영문 대소문자와 숫자로만 입력</span></td>
         </tr>
         <tr>
            <td class = "atrr" align=center> <font size=5>PASS-RE : </td> </font>
            <td><input type = "password" id = "checkpw" maxlength="12" style=" width:250pt; height:20pt; font-size:15pt; background-color:transparent;"></td>
         </tr>
         <tr>
            <td class = "atrr" align=center> <font size=5>E-MAIL: </td> </font>
            <td><input type = "text" name = "member_email" id ="member_email" style=" width:250pt; height:20pt; font-size:15pt; background-color:transparent;"></td>
         </tr>
         <tr>
            <td class = "atrr" align=center> <font size=5>NAME : </td> </font>
            <td><input type = "text" name = "member_name" id ="member_name" style=" width:250pt; height:20pt; font-size:15pt; background-color:transparent;"></td>
         </tr>
         
            <tr>
            <td colspan = "2">
          <font size=10><center>Privacy Information</center> </font>
            </td>
         </tr>
         
         <tr>
            <td class = "atrr" align=center> <font size=5> IDENTIFICATION NUM : </td> </font>
            <td class = "atrr1">
            <input type = "text" name = "member_num1" id ="member_num1" maxlength="6" style=" width:100pt; height:20pt; font-size:15pt; background-color:transparent;"/>
            <input type = "password" name = "member_num2" id ="member_num2" maxlength="7" onblur="calcul()" style=" width:100pt; height:20pt; font-size:15pt; background-color:transparent;"/>
               </td>
         </tr>
         <tr>
            <td class = "atrr" align=center> <font size=5> BIRTH (AUTO) : </td></font>
            <td class = "atrr1"> 
                <input type="text" style="width:80px" id="year" name = "year"  style=" width:250pt; height:20pt; font-size:15pt; background-color:transparent;" readonly/>Y
                     <input type="text" style="width:80px" id="month" name = "month"  style=" width:250pt; height:20pt; font-size:15pt; background-color:transparent;" readonly/>M
              <input type="text" style="width:80px" id="day" name = "day"  style=" width:250pt; height:20pt; font-size:15pt; background-color:transparent;" readonly/>D
                    
            </td>   
         </tr>
         <tr>
            <td class = "atrr" align=center> <font size=5> INTEREST : </td></font>
            <td class = "atrr1"> 
                <input type= "checkbox" name = "member_hobby" value = "컴퓨터" style="background-color:transparent;">컴퓨터 
                <input type= "checkbox" name = "member_hobby" value = "영화" style="background-color:transparent;">영화 
                <input type= "checkbox" name = "member_hobby" value = "배드민턴" style="background-color:transparent;">배드민턴 
                <input type= "checkbox" name = "member_hobby" value = "자전거" style="background-color:transparent;">자전거 
                <input type= "checkbox" name = "member_hobby" value = "운동" style="opactcity:0;">운동 
            </td>   
         </tr>
         <tr>
            <td class = "atrr" align=center> <font size=5>  MEMO: </td></font>
            <td> 
                <textarea name = "member_mempr" cols = "55" rows = "2"  style="font-size:15pt; background-color:transparent;"></textarea>
            </td>   
         </tr>
         <tr >
            <td colspan = "2"  align = "center">
            <p>
           <b> <input type="submit" value="JOIN" style="width:60pt; height:30pt; font-size:18pt; background-color:transparent;"></b>
          &emsp; &emsp;  <b> <input type = "reset" value = "RESET" style="width:80pt; height:30pt; font-size:18pt; background-color:transparent;"></b>
                  </p>
               </td>
            </tr>  
      
      </table></b>
      </center>
      </form>


</body>
</html>