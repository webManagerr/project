<%-- 
    Document   : index
    Created on : 25.09.2014, 13:11:37
    Author     : Denis
--%>

<%@page import="java.util.List"%>
<%@page import="web.Tools"%>
<%@page import="test.WorkspaceFactory"%>
<%@page import="org.radixware.web.manager.DistributionKits"%>
<%@page import="org.radixware.web.manager.Dir"%>
<%@page import="org.radixware.web.manager.ExternalProduct"%>
<%@page import="org.radixware.web.manager.NodeList"%>
<%@page import="org.radixware.web.manager.ExternalProducts"%>
<%@page import="org.radixware.web.manager.Node"%>
<%@page import="org.radixware.web.manager.Project"%>
<%@page import="org.radixware.web.manager.Workspace"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="utf-8">

        <title>List</title>


        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/starter-template.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <script src="js/jquery-2.1.1.min.js"></script>
        <script src="js/sylvester.src.js"></script>
        <script src="js/jqary.js"></script>

    </head>
    <body>
        <%
            String listId = request.getParameter("id");
            ExternalProducts exs = ((ExternalProducts)WorkspaceFactory.getInstance().findNodeById(listId));
            
            String idProject = exs.getParent().getId();
            String nameProject = exs.getParent().getName();
            
        %>
         <div class="list-nav">      
            <ul class="nav">
                <li></li>
                <li><a href="#Config">Config</a></li>
                <li class="active-li"><a>Distribution Kits</a></li>
                <li><a href="#Scripts">Scripts</a></li>
                <li><a href="#Development">Development</a></li>
                <li><a href="#Releses">Releses</a></li>
                <li><a href="#Customes">Customes</a></li>
                <li><a href="#Test">Test</a></li>
                <li><a href="#Prod">Prod</a></li>
            </ul>
        </div>
        <div class="wrapper active">
            <div class="menu">
                <a href="#" id="Menu1">&#9776;</a>
                <%
                    List<String> ref = Tools.generateReference(exs);
                    for (String s: ref){
                        out.println(s);
                    }                
                %>
                <div class="home"><a href="workspace.jsp"><img src="image/home.png"/></a></div>
            </div>
            <div class="text-div">
                <table class="table">
                    <tr>
                        <th>№</th>
                        <th>Project</th>
                    </tr>
                    <%
                        int i = 1;  
                        for (ExternalProduct element : exs) {
                            
                            out.println("<tr>"
                                    + "<td>" + i + "</td>"
                                    + "<td><a href='distribs.jsp?id=" + element.getId() + "'>" + element.getName() + "</a></td>"
                                    + "</tr>");
                            i++;
                        }
                    
                    %>
                </table>

                <br/>

            </div>
        </div>

    </body>
</html>
