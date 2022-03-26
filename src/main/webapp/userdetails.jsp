<%@page import="java.util.List"%>
<%@page import="com.app.main.model.Users"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>User Details</title>
<style>
.button 
{
  background-color: orange/* 0#4CAF5 */;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 42px;
  cursor: pointer;
}
h1 
{
	color: purple;
}  
body 
{  
    font-size: 100%; 
   /* 	background-color: threedshadow;  */
    background-image: url("c.jpg");
	margin-left:100px;
}
th 
{
  height: 50px;
}
table, th, td 
{  
    border: 1px solid black;  
    border-collapse: collapse;  
    border-color: purple;
}  
th, td 
{  
    padding: 10px; 
    border-radius: 1mm; 
    padding: 25px;
}  
table#alter tr:nth-child(even) 
{  
    background-color: #eee;  
}  
table#alter tr:nth-child(odd) 
{  
    background-color: #fff;  
}  
table#alter th 
{  
    color: white;  
    background-color: maroon;  
} 
</style>
</head>
<script type="text/javascript">
function updaterecord() 
{
	alert("Confirm Update");
	document.myform.action="edituser";
	document.myform.submit();
}
</script>
<body>
<h1>USER DETAILS</h1>
<form name="myform">
<table id="alter" border="2">
<tr>
<th>Select</th>
<th>User ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email Address</th>
<th>Phone Number</th>

<th>Password</th>
</tr>
<c:forEach items="${data}" var="userdetails">
<tr>
<td><input type="radio" name="userid" value="${userdetails.userid}"></td>
<td>${userdetails.userid }</td>
<td>${userdetails.firstname }</td>
<td>${userdetails.lastname }</td>
<td>${userdetails.emailaddress }</td>
<td>${userdetails.phonenumber }</td>

<td>${userdetails.password }</td>
</tr>
</c:forEach>
</table>
<br>
<input type="button" class="button" value="Update" onclick="updaterecord()">
</form>
</body>
</html>