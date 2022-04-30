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
</style>
</head>
<body>
<div class="topnav">
  <a href="/login/driverpage/driverprofile">PROFILE</a>
  <a href="/login/driverpage/driverride">SELECT RIDES</a>
  <span style="float:right">
<a href="/logout"> LOG OUT </a> </span>
</div><br><br>
<table>

 <tr> 
  <td><label>BOOKING ID </label></td>
  <td>&nbsp:<span><c:out value="${ride_details.booking_id}" /></span></td>
  </tr>
  <tr>
  <td><label>SOURCE </label></td>
  <td>&nbsp:<span><c:out value="${ride_details.source }" /></span></td>
  </tr>
  <tr>
   <td><label>DESTINATION </label></td>
  <td>&nbsp:<span><c:out value="${ride_details.destination }" /></span></td>
  </tr>
  <tr>
   <td><label>PICK UP TIME </label></td>
  <td>&nbsp:<span><c:out value="${ride_details.pick_up_time }" /></span></td>
  </tr>
  <tr>
   <td><label>USER ID </label></td>
  <td>&nbsp:<span><c:out value="${ride_details.user_username}" /></span></td>
  </tr>
  </table>
<form method="post" > 
<input type="hidden" name="booking_id" value="${ride_details.booking_id}"/> 
  Enter Price:  
  <input type="text" name="rate" required/><br>
  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button type="submit" >CONFIRM RIDE</button> 
  </form>
  
  ${message} 
</body>
</html>