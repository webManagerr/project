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
        <%
    
    
    Project project = node.getProjectParent();
    String externalProductId = project.getExternalProducts().getId();
%>
<div class="list-nav">      
    <ul class="nav">
        <li> </li>

        <li><a href="#Config">Config</a></li>
        <li><a href="list.jsp?id=<%=externalProductId%>">Distribution Kits</a></li>
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
        <a href="#" id="menu-submit">&#9776;</a>

        <%
            List<String> ref = Tools.generateReference(node);
            if (!ref.isEmpty()) {
                if (ref.size() > 2) {
        %>
        <a href="#" id="list-folder"><img src="image/folder.png" class="image" ></a>
        <div class="menu-list" style="display:none">
            <div class="menu-list-arrow-border"></div>
            <div class="menu-list-arrow"></div>
            <ul>
                <ul>
                    <%
                        for (int i = 2; i < ref.size(); i++) {
                            out.println("<li>" + ref.get(i) + "</li>");
                        }

                    %>  
                </ul>
        </div>
        <%                            out.println(ref.get(1) + "<img src='image/arrow-right-grey.png' class = 'image'>" + ref.get(0));
                } else if (ref.size() == 2) {
                    out.println(ref.get(1) + "<img src='image/arrow-right-grey.png' class = 'image'>" + ref.get(0));
                } else {
                    out.println(ref.get(0));
                }
            }
        %>
        <div class="home"><a href="workspace.jsp"><img src="image/home.png"/></a></div>
    </div>
            <div class="text-div">
                <table class="table">
                    <tr>
                       
                        <th><%=coloms.get(0)%></th>
                    </tr>
                    <%  
                        Class nodeInterface = listAdapter.getNodeClass(node);
                        
                        if (ExternalProduct.class.equals(nodeInterface)){
                            node = ((ExternalProduct)node).getDistributionKits();
                        }
                        
                       List<Node> nodeList = ((Dir)node).getNodeList().getNodes();
                       out.print(nodeList.toString());
//                        for (Node element : nodeList) {
//                            out.println("<tr>"
//                                    + "<td><a href='"+row+"?id=" + element.getId() + "'>" + element.getName() + "</a></td>"
//                                    + "</tr>");
//                        }

                    %>
                </table>

                <br/>

            </div>
        </div>

    </body>
</html>
