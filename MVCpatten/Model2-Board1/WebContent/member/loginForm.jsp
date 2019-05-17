<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

   
   body{
      background-image: url("./member/1313.jpg");
      background-repeat: no-repeat;
      background-size: cover;
      
   }
   
   
   
</style>
</head>
<body>
<form name="loginform" action="./MemberLoginAction.me" method="post">
    <br><br><br><br><br><br><br><br><br><br><br>
    <center>
        <table width=600px;  border=1>
             <tr>
                  <td colspan="2" align=center  ;>
                  <b><font size=20>LOGIN</font></b>
                  </td>
                  </tr>
                  <tr><td align=center><b><font size=7> I  D : </font></td><td><input type="text" name="member_id" id = "member_id" style="width:250pt; height:30pt; font-size:18pt; background-color:transparent; "></b></td></tr>
                  <tr><td align=center><b><font size=7> PASS : </font></td><td><input type="password" name="member_pw" id = "member_pw" style="width:250pt; height:30pt;font-size:18pt; background-color:transparent;"></b></td></tr>
                  <tr>
                  <td colspan="2" align=center>
                 <b><input type="submit" value="login" style="width:60pt; height:30pt; font-size:18pt; background-color:transparent;">   </b>              
         &emsp; &emsp;<b><a href ="MemberJoin.me" style="font-size:20pt; color:black;">joinus</a> </b> 
              </td>
            </tr>
        </table>
    </center>
</form>
</body>
</html>