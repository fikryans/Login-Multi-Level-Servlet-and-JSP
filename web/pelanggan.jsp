<%-- 
    Document   : pelanggan
    Created on : Dec 11, 2016, 10:44:41 PM
    Author     : TutorialPedia.NET
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Halaman Pelanggan</title>
    </head>
    <body>
        <%
            if ((session.getAttribute("username") == null) || (session.getAttribute("hak_akses"))== "Admin" ){
                response.sendRedirect("index.jsp");
        %>
        <%
        }
        %>
        <h1>Hallo  <%=session.getAttribute("username") %></h1>
       
        
        <a href="Login?proses=logout">Logout</a>

    </body>
</html>
