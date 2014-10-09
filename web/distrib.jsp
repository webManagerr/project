<%-- 
    Document   : distrib
    Created on : 27.09.2014, 18:36:00
    Author     : Denis
--%>

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
            DistributionKit dk = (DistributionKit)WorkspaceFactory.getInstance().findNodeById(listId);
            ExternalProduct ep = (ExternalProduct)dk.getParent().getParent();
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
    <%=Tools.generateReference(dk)%>
    <div class="home"><a href="workspace.jsp"><img src="image/home.png"/></a></div>
  </div>
     <div class="text-div">
    
        <div>
         <table class="table">
             <tr>
                 <th><%=ep.getName()%></th>
                 <th><%%></th>
            </tr>     
                 
            </table>
         </div><br/>
         <div>
             <h4>Release version</h4>
         <table class="table">
             <tr>
             <th>URL</th>
            </tr>     
               <tr>
                   <td>org.raxware</td>
             </tr>  
            </table>
         </div><br/>
         <div>
             <h4>Scripts</h4>
         <table class="table">
             <tr>
             <th>URL</th>
            </tr>     
               <tr>
                   <td>org.raxware</td>
             </tr>  
            </table>
         </div>
    
    </div>
</div>
    
      </body>
</html>
