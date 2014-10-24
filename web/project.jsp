<%-- 
    Document   : page
    Created on : 25.09.2014, 14:30:26
    Author     : Denis
--%>

<%@page import="web.ListAdapter"%>
<%@page import="java.util.List"%>
<%@page import="web.Tools"%>
<%@page import="test.WorkspaceFactory"%>
<%@page import="org.radixware.web.manager.Project"%>
<%@page import="org.radixware.web.manager.Node"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="utf-8">

        <title>mainMenu</title>


        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/starter-template.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <script src="js/jquery-2.1.1.min.js"></script>
        <script src="js/jquery.cookie.js"></script>
        <script src="js/sylvester.src.js"></script>
        <script src="js/jqary.js"></script>

    </head>

    <body>
        <%
            
            String id = request.getParameter("id");
            Project node = (Project) WorkspaceFactory.getInstance().findNodeById(id);
        %>
        <%@include file="menu.jsp" %>
        
            <div class="text-div">
                <h4>Svn Home URl: <%=node.getSvnHomeUrl()%></h4>
                
            </div>
        </div>
    </body>
</html>

