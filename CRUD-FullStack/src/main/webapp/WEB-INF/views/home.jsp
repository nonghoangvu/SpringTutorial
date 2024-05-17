<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 class="text-center">Student Management</h1>
<h1>Current: ${students.number}</h1>
<h1>Total pages: ${students.totalPages - 1}</h1>
<h1>Page count: ${students.number + 1}</h1>
<table class="table text-center">
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
    <c:forEach varStatus="i" var="s" items="${students.content}">
        <tr>
            <th scope="row">${i.index + 1}</th>
            <td>${s.fullName}</td>
            <td>${s.age}</td>
            <td>${s.gender ? "Male" : "Female"}</td>
            <td>
                <button class="btn  btn-outline-danger m-2" onclick="{
                        window.location.href = `http://localhost:8080/app/student/${s.id}`
                        }">Delete
                </button>
                <button class="btn btn-outline-secondary" onclick="{
                        window.location.href = `http://localhost:8080/app/student/update/${s.id}`
                        }">Edit
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="d-flex justify-content-center">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link ${!students.hasPrevious() ? "disabled" : ""} "
                   href="/app/student?p=${students.number - 1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="0" end="${students.number >= 2 ? (student.number <= 4 ? 5 : 6) : 4}" varStatus="i">
                <li class="page-item">
                    <a class="page-link ${students.number == i.index ? "active" : ""}"
                       href="/app/student?p=${i.index}">${i.index + 1}</a>
                </li>
            </c:forEach>

            <li class="page-item">
                <a class="page-link ${!students.hasNext() ? "disabled" : ""}"
                   href="/app/student?p=${students.number + 1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
