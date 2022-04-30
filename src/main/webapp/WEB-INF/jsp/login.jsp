<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<html>

<head>
<title>TAXI WEB  APP</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border:  solid #f1f1f1;}

input[type=text], input[type=password], select[name="usertype"]{
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
.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  color: #f2f2f2;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 25px;
   box-sizing: border-box;
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
 <div class="topnav">
 <br>
 <span style="float:right">
<a href="login"> Log-in </a> | <a href="userregister"> User Registeration </a> | <a href="driverregister"> Driver Registeration </a> </span>
<br>
</div>
<br><br><br>
    <font color="red">${errorMessage}</font>
    <form:form action="login" method="post" modelAttribute="loging">
        User-Name : <form:input path="username" required="true" /><br>
        Password &nbsp : <form:password path="password" required="true" /> <br>
        Login-as &nbsp &nbsp : <form:select name="usertype" path="usertype" id="usertype" required="true" > 
<option value="user">user</option>
<option value="driver">driver</option>
 </form:select><br>
   &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp     <button type="submit">Login</button>
    </form:form>
</body>

</html>