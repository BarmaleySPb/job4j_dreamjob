<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Loading photo</title>
</head>
<body>
<%
    String id = request.getParameter("id");
%>
<td>
    <form action="<%=request.getContextPath()%>/uploadphoto?id=<%=id%>" method="post" enctype="multipart/form-data">
        <div class="checkbox">
            <input type="file" name="file">
        </div>
        <button type="submit" class="btn btn-success">Add</button>
    </form>
</td>
</body>
</html>
