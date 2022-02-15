<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="dream.model.Post" %>
<%@ page import="dream.store.DbStore" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <script>
        function validate() {
            const name = $('#inputTitle').val();
            const description = $('#inputDescription').val();

            if (name === '') {
                alert('Please enter job title.');
                return false;
            }
            if (description === '') {
                alert('Please enter job title.');
                return false;
            }
            return true;
        }
    </script>

    <title>Dream job</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    Post post = new Post(0, "");
    if (id != null) {
        post = DbStore.instOf().findPostById(Integer.parseInt(id));
    }
%>
<div class="container">
    <div class="row">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/posts.do">Vacancies</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/candidates.do">Candidates</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/post/edit.jsp">Add vacancy</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/candidate/edit.jsp">Add candidate</a>
            </li>
        </ul>
    </div>
    <div class="container pt-3">
        <div class="row">
            <div class="card" style="width: 100%">
                <div class="card-header">
                    <% if (id == null) { %>
                    New vacancy.
                    <% } else { %>
                    Edit vacancy.
                    <% } %>
                </div>
                <div class="card-body">
                    <form action="<%=request.getContextPath()%>/posts.do?id=<%=post.getId()%>" method="post">
                        <div class="form-group">
                            <label>Job title</label>
                            <input type="text" class="form-control" name="name" id="inputTitle"
                                   value="<%=post.getName()%>" placeholder="Enter job title">
                        </div>
                        <div class="form-group">
                            <label>Description</label>
                            <input type="text" class="form-control" name="description" id="inputDescription"
                                   placeholder="Enter description of job">
                        </div>
                        <button type="submit" class="btn btn-primary" onclick="return validate();">Save</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>