<%-- 
    Document   : index
    Created on : 25.09.2014, 13:11:37
    Author     : Denis
--%>


<%@page import="web.ListAdapter"%>
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
        <script src="js/jquery.cookie.js"></script>
        <script src="js/sylvester.src.js"></script>
        <script src="js/jqary.js"></script>

    </head>
    <body>
        <%
            String id = request.getParameter("id");
            Node node = WorkspaceFactory.getInstance().findNodeById(id);
            ListAdapter listAdapter = new ListAdapter(node);
            List<String> coloms = listAdapter.getColomsName();
            String row = listAdapter.getRowReference();
        %>
        
        <%@include file="menu.jsp" %>
        <div class="text-div">
            <table class="table">
                <tr>

                    <th><%=coloms.get(0)%></th>
                </tr>
                <%
                    Class nodeInterface = listAdapter.getNodeClass(node);

                    if (ExternalProduct.class.equals(nodeInterface)) {
                        node = ((ExternalProduct) node).getDistributionKits();
                    }

                    List<Node> nodeList = ((Dir) node).getNodeList().getNodes();
                    for (Node element : nodeList) {
                        out.println("<tr>"
                                + "<td><a href='" + row + "?id=" + element.getId() + "'>" + element.getName() + "</a></td>"
                                + "</tr>");
                    }

                %>
            </table>

            <br/>

        </div>
    </div>

</body>
</html>
