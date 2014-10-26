
<%@page import="org.radixware.web.manager.Project"%>
<%@page import="web.Tools"%>
<%@page import="java.util.List"%>
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