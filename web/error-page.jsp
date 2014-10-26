<%@page import="java.io.StringWriter"%>
<%@page import="java.io.PrintWriter"%>
<%@page isErrorPage="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/starter-template.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <title>Error</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="menu">
                <a style="margin-left: 50px;">Opps...</a>
            </div>
            <div class="text-div">
                <table class="table">
                    <tr>
                        <td><b>Error</b></td> 
                        <td><%=exception.toString()%></td> 
                    </tr>
                    <tr>
                        <td><b>URI</b></td> 
                        <td><%=(String) request.getAttribute("javax.servlet.error.request_uri")%></td> 
                    </tr>
                    <tr>
                        <td><b>StackTrace</b></td> 
                        <td><%
                            StringWriter stringWriter = new StringWriter();
                            PrintWriter writer = new PrintWriter(stringWriter);
                            exception.printStackTrace(writer);
                            out.println(stringWriter);
                            writer.close();
                            stringWriter.close();
                            %></td> 
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
