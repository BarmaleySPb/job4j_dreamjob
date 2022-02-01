<%--
  Created by IntelliJ IDEA.
  User: Barmaley
  Date: 2/1/2022
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Загрузить фото</title>
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
        <button type="submit" class="btn btn-success">Добавить</button>
    </form>
</td>
</body>
</html>
