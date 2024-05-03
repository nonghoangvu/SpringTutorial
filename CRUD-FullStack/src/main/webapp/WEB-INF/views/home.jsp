<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 class="text-center">Student Management</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">No</th>
        <th scope="col">Full name</th>
        <th scope="col">Age</th>
        <th scope="col">Gender</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="i" var="s" items="${students}">
        <tr>
            <th scope="row">${i.index + 1}</th>
            <td>${s.fullName}</td>
            <td>${s.age}</td>
            <td>${s.gender ? "Male" : "Female"}</td>
            <td>
                <button class="btn  btn-outline-danger m-2" onclick="{
                    window.location.href = `http://localhost:8080/app/student/${s.id}`
                }">Delete</button>
                <button class="btn btn-outline-secondary" onclick="{
                    window.location.href = `http://localhost:8080/app/student/update/${s.id}`
                }">Edit</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
