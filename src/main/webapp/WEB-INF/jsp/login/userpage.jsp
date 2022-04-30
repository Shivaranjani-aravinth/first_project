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
<h2>WELCOME ${username }</h2>
</body>
</html>