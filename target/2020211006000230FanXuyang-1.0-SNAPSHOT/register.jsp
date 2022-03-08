<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Register</title>
</head>
<body>
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

</body>
</html>
