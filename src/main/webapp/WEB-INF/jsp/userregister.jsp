
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
<title>User-Registeration</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}
input[type=text], input[type=password]{
  width: 30%;
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
  width: 30%;
}
.div1{
background-color:black;
}
</style>
</head>
<body>
<div class="div1"> <font color="white">
<h2>User Registeration</h2> </font></div>
  <font color="red">${errorMessage}</font>
    <form:form action="/userregister" method="post" modelAttribute="user">
        
        First Name: <form:input type="text" path="first_name" required="true"/><br>
        
        Last Name&nbsp: <form:input type="text" path="last_name" required="true"/><br>
        
        User Name : <form:input type="text" path="username" required="true"/><br>
        
        Password &nbsp : <form:input type="password" path="password" required="true"/> <br>
        
        Mail-ID&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp: <form:input type="text" path="mailid" required="true"/> <br>
        
        Phone NO.: <form:input type="text" path="phoneno" required="true"/> <br>
        
        &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp     <button type="submit">Register</button>
    </form:form>
</body>

</html>