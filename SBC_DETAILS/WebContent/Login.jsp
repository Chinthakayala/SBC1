<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
   body
   {
   background-color:#ADD8E6;
   }
</style>
</head>
<body>
<h1 align="center"> SBC LOGIN</h1>
<form action="Sbc" method="post"  >
   <table align="center" >
   <tr>
      <td><font face="verdana" size="2px">Name:</font></td> 	
      <td><input type="text" name="userName"></td>
   </tr>
   <tr>
      <td><font face="verdana" size="2px">Password:</font></td>
      <td><input type="password" name="userPassword"></td>
   </tr>
   </table>
   <br>
   <div align="center">   <input type="submit" value="Login" ></div>
</form>
</body>
</html>