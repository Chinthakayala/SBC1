<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
 <meta charset="ISO-8859-1">
 <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script> 

<title>SBC</title>
<style>
tr
{
text-align:center;
}

</style>
 
</head>
 
<body>
<script src="validation.js"></script>
<div> 
<form name="f1" method="get">
 
<table border="1" align="center" width="400" bgcolor="#CCCCCC" >
 
<caption><h1>SBC Registration form</h1></caption>
 
	<tr>
	 
	     <th>Si.no</th>
	 
	     <td><input type="text" name="si.no" id="fn1" maxlength="10" title="enter your first name" placeholder="" required/></td>
	 
	</tr>
 
	<tr>
	 
		<th>Box Name</th>
		 
		<td><input type="text" id="fn2" name="BoxName" required/></td>
	 
	</tr>
 
	<tr>
	 
		<th>Ip Address</th>
		 
		<td><input type="text" id="fn3" name="Ip" required/></td>
	 
	</tr>
 
	<tr>
	 
		<th>EMA UserName</th>
		 
		<td><input type="text" id="fn4" name="UserName" required/></td>
	 
	</tr>
 
	<tr>
	 
		<th>EMA Password</th>
		 
		<td><input type="password" id="fn5" name="password" required/></td>
	 
	</tr>
 
	<tr>
	 
		<th>BMC Ip</th>
		 
		<td><input type="text" id="fn6" name="BmcIp" required/></td>
	 
	</tr>
 
	<tr>
	 
		<th>BMC UserName</th>
		 
		<td><input type="text" id="fn7" name="BmcIpusername" required/></td>
	 
	</tr>
 
	<tr>
	 
		<th>BMC Password</th>
		 
		<td><input type="password" id="fn8" name="BmcPass" required/></td>
	 
	</tr>
 
	<tr>
	 
		<th>Software Load</th> 
		<td><input type="text" id="fn9" name="SoftwareLoad" required/></td>
	 
	</tr>
 
	<tr>
	 
		<th>Assign To</th> 
		<td><input type="text" id="fn10" name="Assign" required/></td>
	 
	</tr>
 
	<tr>
	 
		<th>Reversed By</th>
		 
		<td><input type="text" id="fn11" name="ReversedBy" required/></td>
	 
	</tr>
 
	<tr>
	 
	    <th>Reserved Until</th>
			 
		<td><input type="text" id="fn12" name="Reserved" required/></td>
	 
	</tr>
 
	<tr>
	 
		<th>VLAN</th>
			 
		<td><input type="text" id="fn13" name="Vlan"/></td>
	 
	</tr>
	<tr>
	 
		<th>Comments</th>
			 
		<td><input type="text" id="fn14" name="Cmts"/></td>
	 
	</tr>
</table>
<div class="centerBlock" style="text-align:center; margin-top: 25px;"><input type="button" name="submit" onclick="ValidateIPaddress(document.f1.Ip, document.f1.Vlan, document.f1.BmcIp)" value="submit"/></div>

</form>
</div> 
</body>
 
</html>