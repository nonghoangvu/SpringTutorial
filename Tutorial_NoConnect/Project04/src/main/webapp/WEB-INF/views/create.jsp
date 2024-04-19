<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="text-center mb-3">Create</h1>
    <form action="/add" method="post">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="username" name="username">
            <label for="username">Username</label>
        </div>
        <div class="form-floating mb-3">
            <input type="password" class="form-control" id="password" name="password">
            <label for="password">Password</label>
        </div>
        <div class="form-floating mb-3">
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" id="role_admin" value="Admin" name="role">
                <label class="form-check-label" for="role_admin">Admin</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" id="role_client" value="Client" name="role">
                <label class="form-check-label" for="role_client">Client</label>
            </div>
        </div>
         <button class="btn btn-success">Submit</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>
