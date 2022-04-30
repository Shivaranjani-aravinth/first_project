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
input[type=text]{
  width: 20%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 20%;
  text-align:center;
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
<div class="topnav">
  <a href="/login/driverpage/driverprofile">PROFILE</a>
  <a href="/login/driverpage/driverride">SELECT RIDES</a>
  <span style="float:right">
<a href="/logout"> LOG OUT </a> </span>
</div><br><br>
  <form action="/login/driverpage/driverride" method="post" >
   SEARCH :&nbsp
  <input type="text" name="source" required/>
  <button type="submit">SEARCH</button>
  </form><br>
  <table>
  <tr> 
  <td><b>BOOKING_ID</b> </td>
   <td><b>SOURCE</b></td>
   <td><b>DESTINATION</b></td>
   <td><b>PICKUP_TIME</b></td>
   <td><b>USER_NAME</b></td>
   <td><b>SELECT_RIDE</b></td>
  
  </tr>
  <c:forEach var="item" items="${source_ride}" >
  <tr>
   <td>${item.booking_id }</td>
  <td>${item.source}</td>  
  <td>${item.destination}</td> 
  <td>${item.pick_up_time }</td>
  <td>${item.user_username}</td>
  <td><a href="/login/driverpage/confirmride?booking_id=${item.booking_id }">Click_to_Confirm</a></td>
  </tr>
  </c:forEach>
  </table>
  <br>
  ${message}
  <br>
  <br>
  Click on the link to confirm user ride
</body>
</html>