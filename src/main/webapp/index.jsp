<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String isAdmin = request.getSession().getAttribute("ISADMIN") +"";
    if(!isAdmin.equals("admin")){
%>
<jsp:forward page="/secured/dashboardCondidat.jsf" />
<%
    }else{
%>
<jsp:forward page="/admin/dashboard.jsf" />
<%
    }
%>




</body>
</html>
