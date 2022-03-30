<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
  <title>Register</title>
</head>
<body>
<div style="text-align: center;">
<form method="post" action="register">
  ID : <input type="text" name="ID" /> <br/>
  Username: <input type="text" name="username"/><br/>
  Password: <input type="password" name="password"/><br/>
  Email: <input type="text" name="email"/><br>
  Gender: <input type="radio" name="gender" value="male" checked="checked"/>男
  <input type="radio" name="gender" value="female" />女<br/>
  Birthdate: <input type="text name=" name="Birthdate" /><br/>
  <input type="submit" value="Register"/>
</form>
</div>
</body>
</html>
<%@include file="footer.jsp"%>
