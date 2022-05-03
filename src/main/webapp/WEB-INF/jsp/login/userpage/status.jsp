<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 30%;
}
</style>
</head>
<body>
<div class="topnav">
  <a href="/login/userpage/profile">PROFILE</a>
 
  <a href="/login/userpage/ride">BOOK YOUR RIDE</a>
  
  <a href="/login/userpage/status">RIDE STATUS</a>
   <span style="float:right">
<a href="/logout"> LOG OUT </a> </span>
</div>
<br>
<c:choose>
<c:when test="${ride == null }">
No Rides Booked Yet! 
</c:when>
<c:when test="${ride.driver_username == null}">
Waiting for Driver to get assigned <br>
check after some time!!!
</c:when>
<c:otherwise >
<form method="post" action="/login/userpage/status">
<table>
 <tr> 
  <td><label>BOOKING_ID </label></td>
  <td><span><c:out value="${ride.booking_id }" /></span></td>
  </tr>
  <tr>
  <td><label>SOURCE </label></td>
  <td><span><c:out value="${ride.source }" /></span></td>
  </tr>
  <tr>
   <td><label>DESTINATION </label></td>
  <td><span><c:out value="${ride.destination }" /></span></td>
  </tr>
  <tr>
   <td><label>PICK UP TIME </label></td>
  <td><span><c:out value="${ride.pick_up_time }" /></span></td>
  </tr>
  <tr>
   <td><label>DRIVER NAME </label></td>
  <td><span><c:out value="${ride.driver_username}" /></span></td>
  </tr>
  <tr>
   <td><label>RATE </label></td>
  <td><span><c:out value="${ride.rate}" /></span></td>
  </tr>
  </table>
  <br>
<input type="hidden" name="booking_id" value="${ride.booking_id }" />
<input type="submit" name="submit" />
</form>
<br>
${message} 
</c:otherwise>
</c:choose>
</body>
</html>