<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Driver-Page</title>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
tr {
  border-bottom: 1px solid #ddd;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  width:30%;
}
tr:nth-child(even) {
  background-color: #D6EEEE;
}
</style>
</head>
<body>
<%-- Hi ${username}! --%>
<%-- s it in synch ${test } --%>
<div class="topnav">
  <a href="/login/driverpage/driverprofile">PROFILE</a>
 
  <a href="/login/driverpage/driverride">SELECT RIDES</a>
  
  
   <span style="float:right">
<a href="/logout"> LOG OUT </a> </span>
</div>
<br>
<div style="padding-left:16px">
<h3>DRIVER DETAILS</h3>
<table>

 <tr> 
  <td><label>FIRST NAME </label></td>
  <td><span><c:out value="${driver.first_name }" /></span></td>
  </tr>
  <tr>
  <td><label>LAST NAME </label></td>
  <td><span><c:out value="${driver.last_name }" /></span></td>
  </tr>
  <tr>
   <td><label>EMAIL ID </label></td>
  <td><span><c:out value="${driver.mailid }" /></span></td>
  </tr>
  <tr>
   <td><label>PHONE NUMBER </label></td>
  <td><span><c:out value="${driver.phoneno }" /></span></td>
  </tr>
  <tr>
   <td><label>LICENSE NUMBER </label></td>
  <td><span><c:out value="${driver.licenseno }" /></span></td>
  </tr>
  </table>
</div>

</body>
</html>