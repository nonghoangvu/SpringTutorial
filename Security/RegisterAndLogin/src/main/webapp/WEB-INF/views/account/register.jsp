<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1 class=" text-center">Register</h1>
    <form:form action="/register" method="post" modelAttribute="user">
        <form:errors path="*" element="div" cssClass="alert-danger alert"/>
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <form:input path="username" type="text" class="form-control" id="username" name="username"/>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <form:input path="password" type="password" class="form-control" id="password" name="password"/>
        </div>
        <div class="mb-3">
            <form:checkbox path="role" cssClass="form-check-label form-check-input" value="ADMIN" label="Role"/>
        </div>
        <button type="submit" class="btn btn-primary">Register</button>
    </form:form>
</div>
</body>
</html>
