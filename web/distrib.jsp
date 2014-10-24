<%-- 
    Document   : distrib
    Created on : 27.09.2014, 18:36:00
    Author     : Denis
--%>

<%@page import="web.ListAdapter"%>
<%@page import="org.radixware.web.manager.Release"%>
<%@page import="web.Tools"%>
<%@page import="org.radixware.web.manager.DistributionKit"%>
<%@page import="test.WorkspaceFactory"%>
<%@page import="java.util.List"%>
<%@page import="org.radixware.web.manager.ExternalProduct"%>
<%@page import="org.radixware.web.manager.Node"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="utf-8">

        <title>Distrib</title>


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
            DistributionKit node = (DistributionKit) WorkspaceFactory.getInstance().findNodeById(id);
            Release release = node.getRelease();
            ListAdapter listAdapter = new ListAdapter(WorkspaceFactory.getInstance().findNodeById(id));

        %>
        <%@include file="menu.jsp" %>
       
            <div class="text-div">

                <div class="discription">
                    <h4>Created <%=node.getCreateTime().toString()%> previous number <%=node.getPrevVersion()%></h4>
                    <%  String discription = node.getDescription();
                        if (discription != null) {
                    %>
                    <div class="discription">
                        <h4>Description</h4>
                        <p><%=discription%></p>
                        <%}%>
                    </div>
                    <% if (!node.getChangeList().isEmpty()) {%>
                    <div class="discription">             
                        <h4>Changes list</h4>
                        <%
                            for (String change : node.getChangeList()) {
                        %>
                        <p><%=change%></p>
                        <%
                            }
                        %> 

                    </div><br/><%}%>                    
                    <div class="discription">
                        <h4>Based on releases <%=release.getVersion()%> with status <%=release.getStatus()%></h4>
                        <table class="table">
                            <tr>
                                <th>Name</th>
                                <th>URI</th>
                                <th>Layer Version</th>
                            </tr>     
                            <tr>
                                <td><%=release.getVersion()%>></td>
                                <td>none</td>
                                <td>none</td>
                            </tr>  
                        </table>
                    </div><br/>
                    <div class="discription">
                        <h4>Contains scripts for layers</h4>
                        <table class="table">   
                            <tr>
                                <td>org.raxware</td>
                            </tr>  
                        </table>
                    </div>

                </div>
            </div>

    </body>
</html>
