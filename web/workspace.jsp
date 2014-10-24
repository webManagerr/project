<%-- 
    Document   : index
    Created on : 25.09.2014, 13:11:37
    Author     : Denis
--%>

<%@page import="org.radixware.web.manager.Node"%>
<%@page import="test.WorkspaceFactory"%>
<%@page import="org.radixware.web.manager.Project"%>
<%@page import="org.radixware.web.manager.Workspace"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="utf-8">

        <title>Workspace</title>


        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/starter-template.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <script src="js/jquery-2.1.1.min.js"></script>
        
        <script src="js/sylvester.src.js"></script>
        <script src="js/jqary.js"></script>

    </head>
    <body>
        <div class="wrapper">
            <div class="menu">
                <a style="margin-left: 50px;">Workspace</a>
            </div>
            <div class="text-div">
                <table class="table">
                    <tr>
                        <th>Project</th>
                    </tr>
                    <%
                        Workspace work = WorkspaceFactory.getInstance();
                        for (Node p : work.getProjectList().getNodeList().getNodes()) {
                            out.println("<tr>"
                                    + "<td><a href='project.jsp?id=" + p.getId() + "'>" + p.getName() + "</a></td>"
                                    + "</tr>");

                        }
                    %>
                </table>

                <br/>

            </div>
        </div>

    </body>
</html>
