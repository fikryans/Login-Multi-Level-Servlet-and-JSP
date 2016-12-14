<%-- 
    Document   : admin
    Created on : Dec 11, 2016, 10:44:16 PM
    Author     : TutorialPedia.NET
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Halaman Admin</title>
    </head>
        <%
            if ((session.getAttribute("hak_akses") == null) || (session.getAttribute("hak_akses") == "Pelanggan")) {
                response.sendRedirect("index.jsp");
        %>
        <%
            }
        %>
    <body>
        <h1>Hallo <%=session.getAttribute("username")%> </h1>
        
        <a href="Login?proses=logout">Logout</a>
    </body>
</html>
