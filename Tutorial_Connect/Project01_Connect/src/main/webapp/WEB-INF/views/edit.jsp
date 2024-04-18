<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Nong Hoang Vu</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center">Update Account</h1>
    <form:form action="/update?id=${ACCOUNT.id}&name=${ACCOUNT.username}" method="post" modelAttribute="ACCOUNT">
        <form:errors path="*" cssClass="alert alert-danger" element="div"></form:errors>
        <div class="form-floating mb-3">
            <form:input type="text" class="form-control" id="username" path="username" maxlength="10"/>
            <label for="username">Username</label>
        </div>
        <div class="form-floating mb-3">
            <form:input type="password" class="form-control" id="password" path="password"/>
            <label for="password">Password</label>
        </div>
        <div class="form-floating mb-3">
            <form:input type="text" class="form-control" id="fullname" path="fullName"/>
            <label for="fullName">FullName</label>
        </div>
        <div class="form-floating mb-3">
            <form:select path="role" class="form-select">
                <option selected disabled>Role</option>
                <form:options items="${ROLES}" itemValue="id" itemLabel="roleKey"/>
            </form:select>
        </div>
        <div class="text-center">
            <a href="/" class="btn btn-danger">Back</a>
            <button type="submit" class="btn btn-warning">Save</button>
        </div>
    </form:form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</html>
