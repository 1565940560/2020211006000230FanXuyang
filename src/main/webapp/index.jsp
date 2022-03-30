<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<div style="text-align: center;">
    <h2>Welcome to My Online shop Home page</h2> <br/>
    <form method="post" target="_blank" action="SearchServlet">
        <input type="text" name="txt" size = 55 />
        <select name="search">
            <option value="baidu">Baidu</option>
            <option value="bing">Bing</option>
            <option value="goolge">Google</option>
        </select>
        <input type="submit" value="Search">
    </form>

    <br/><br/>
<a href="hello-servlet">Hello Servlet - week1</a>
<br/>
<a href="hello">Student Info Servlet - week2</a>
<br/>
<a href="register">Register and JDBC - week3 and week4</a>
<br/>
<a href="register.jsp">register - week4</a>
<br/>
<a href="config">config - week4</a>
<br/>
<a href="week5/Myjsp.jsp">Myjsp - week5</a>
<br/>
    <b><a href="Login.jsp">Login - week5</a></b>
</div>
<%@include file="footer.jsp"%>
