<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
input[type=text], input[type=password]{
  width: 100%;
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
  width: 100%;
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
<div>
<form  method="post"><br>
<table>
<tr>
<td>Source: </td><td><input type=text name="source" required/></td>
</tr>
<tr>
<td>Destination: </td><td><input type=text name="destination" required/></td>
</tr>
<tr>
<td>Pick Up Time:</td><td><input type=text name="pick_up_time" required/></td>
<td><i><font size="3px" color="red">(Type in the format HH:MM )</font></i></td>
</tr>
<tr>
<td></td><td><button type="submit">Book</button></td>
</tr>
</table>
</form>
</div>
</body>
</html>