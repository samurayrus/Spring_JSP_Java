<%-- 
    Document   : newjsp
    Created on : 26.09.2019, 14:57:09
    Author     : Student1
--%>

<%@page contentType="text/html" import="java.util.Date" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="obj" class ="test.Employee"scope="session" />
    <body>
        <h1>Hello World! </h1>
        <h2>Server time =<font size='5' color ='black' face='Calibri'><%=new Date() %></h2>
        <%
             String s = new Date().toString();
       // for(int i =0; i<obj.getEmployees(12).length;i++)
        //{out.println("<br>"); out.println(obj.getEmployees(12)[i]);}
            for(String ss: obj.getEmployees(12))
            {out.println("<br>");out.println(ss);}
        %>
        <br></font>
        <%
//        out.println(s); 
        %>
    </body>
</html>
