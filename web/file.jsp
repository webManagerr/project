<%-- 
    Document   : file.jsp
    Created on : Oct 30, 2014, 12:37:54 PM
    Author     : Alena
--%>

<%@page import="test.WorkspaceFactory"%>
<%@page import="org.radixware.web.manager.Node"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File</title>
    </head>
    <body>
        <%
             String id = request.getParameter("id");
             Node node = WorkspaceFactory.getInstance().findNodeById(id);
        %>
            <%@include file="menu.jsp" %>
            <div class="text-div">
                <ul id = "tabs">
                    <li id="file-tab" class="tab selected-tab"><a href="file.jsp">File</a></li>
                    <li id="modules-tab" class="tab"><a href="#">Modules</a></li>
                </ul>
            </div>
        </div>
    </body>
</html>
