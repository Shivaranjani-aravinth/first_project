<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>User-Page</title>
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
  <a href="/login/userpage/profile">PROFILE</a>
 
  <a href="/login/userpage/ride">BOOK YOUR RIDE</a>
  
  <a href="/login/userpage/status">RIDE STATUS</a>
   <span style="float:right">
<a href="/logout"> LOG OUT </a> </span>
</div>
<br>
<div style="padding-left:16px">
<h3>USER DETAILS</h3>
<table>

 <tr> 
  <td><label>FIRST NAME </label></td>
  <td><span><c:out value="${user.first_name }" /></span></td>
  </tr>
  <tr>
  <td><label>LAST NAME </label></td>
  <td><span><c:out value="${user.last_name }" /></span></td>
  </tr>
  <tr>
   <td><label>EMAIL ID </label></td>
  <td><span><c:out value="${user.mailid }" /></span></td>
  </tr>
  <tr>
   <td><label>PHONE NUMBER </label></td>
  <td><span><c:out value="${user.phoneno }" /></span></td>
  </tr>
  </table>
</div>

</body>
</html>