<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users page</title>
</head>
<body>
    <h1>Users page</h1>
    <p>You see the data below:</p>

    <%
        // Get the 'name' parameter from the request
        String name = request.getParameter("name");

        if(name != null && !name.trim().isEmpty()) {
    %>
        <p><strong>Name:</strong> <%= name %></p>
    <%
        } else {
    %>
        <p>No name submitted yet.</p>
    <%
        }
    %>
</body>
</html>
