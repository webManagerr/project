<%-- 
    Document   : distrib
    Created on : 27.09.2014, 18:36:00
    Author     : Denis
--%>

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
        <script src="js/sylvester.src.js"></script>
        <script src="js/jqary.js"></script>

    </head>
    <body>
        <%
            String listId = request.getParameter("id");
            DistributionKit dk = (DistributionKit) WorkspaceFactory.getInstance().findNodeById(listId);
            Release release = dk.getRelease();


        %>
        <div class="list-nav">      
            <ul class="nav">
                <li></li>
                <li><a href="#Config">Config</a></li>
                <li class="active-li"><a href="#">Distribution Kits</a></li>
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
                <%     List<String> ref = Tools.generateReference(dk);
                    if (!ref.isEmpty()) {
                        if (ref.size() > 2) {
                %>
                <a href="#" id="list-folder"><img src="image/folder.png" class="image" ></a>
                <div class="menu-list" style="display:none">
                    <div class="menu-list-arrow-border"></div>
                    <div class="menu-list-arrow"></div>
                    <ul>
                        <%
                            for (int i = 0; i < ref.size() - 2; i++) {
                                out.println("<li>" + ref.get(i) + "</li>");
                            }
                        %>  
                    </ul>
                </div>
               <%                            out.println(ref.get(ref.size() - 2) + "<img src='image/arrow-right-grey.png' class = 'image'>" + ref.get(ref.size() - 1));
                        } else if (ref.size() == 2) {
                            out.println(ref.get(0) + "<img src='image/arrow-right-grey.png' class = 'image'>" + ref.get(1));
                        } else {
                            out.println(ref.get(0));
                        }
                    }
                %>
                <div class="home"><a href="workspace.jsp"><img src="image/home.png"/></a></div>
            </div>
            <div class="text-div">

                <div>
                    <h4>Created <%=dk.getCreateTime().toString()%> previos number <%=dk.getPrevVersion()%></h4>
                    <table class = "table tabel-distrib">
                        <caption>Discription</caption>
                        <tr><td><%=dk.getDescription()%></td></tr>
                    </table>
                    <table class = "table tabel-distrib">
                        <caption>Changes list</caption>
                        <%
                            for (String change : dk.getChangeList()) {
                        %>
                        <tr><td><%=change%></td></tr>
                        <%
                            }
                        %> 
                    </table>

                </div><br/>
                <div>
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
                            <td>nonde</td>
                        </tr>  
                    </table>
                </div><br/>
                <div>
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
