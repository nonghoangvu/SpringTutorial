<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1 class="text-center">List Account</h1>
    <div class="text-start mt-3 mb-3">
        <a href="/create" class="btn btn-success">Create</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Username</th>
            <th scope="col">FullName</th>
            <th scope="col">Role</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="a" items="${ACCOUNTS.content}">
            <tr>
                <td>${a.username}</td>
                <td>${a.fullName}</td>
                <td>${a.role.roleKey}</td>
                <td>
                    <a href="/update?id=${a.id}" class="btn btn-info">Edit</a>
                    <a href="/delete?id=${a.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="row">
        <div class="col-3">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="?page=0&limit=${limit} ">First</a></li>
                    <c:if test="${ACCOUNTS.number > 0}">
                        <li class="page-item"><a class="page-link" href="?page=${ACCOUNTS.number - 1}&limit=${limit}">Previous</a></li>
                    </c:if>
                    <li class="page-item"><span class="page-link">${ACCOUNTS.number + 1}</span></li>
                    <c:if test="${ACCOUNTS.number < ACCOUNTS.totalPages - 1}">
                        <li class="page-item"><a class="page-link" href="?page=${ACCOUNTS.number + 1}&limit=${limit}">Next</a></li>
                    </c:if>
                    <li class="page-item"><a class="page-link" href="?page=${ACCOUNTS.totalPages - 1}&limit=${limit}">Last</a></li>
                </ul>
            </nav>
        </div>
        <div class="col-3">
            <select class="form-select" onchange="window.location.href=this.value" name="limit">
                <option ${limit == 5 ? "selected" : ""}  value="?page=${ACCOUNTS.number}&limit=5">5</option>
                <option ${limit == 10 ? "selected" : ""} value="?page=${ACCOUNTS.number}&limit=10">10</option>
                <option ${limit == 25 ? "selected" : ""} value="?page=${ACCOUNTS.number}&limit=25">25</option>
                <option ${limit == 50 ? "selected" : ""} value="?page=${ACCOUNTS.number}&limit=50">50</option>
            </select>
        </div>
    </div>
<%--    <ul>--%>
<%--        <li>Số thực thể hiện tại: ${ACCOUNTS.numberOfElements}</li>--%>
<%--        <li>Trang số: ${ACCOUNTS.number}</li>--%>
<%--        <li>Kích thước trang: ${ACCOUNTS.size}</li>--%>
<%--        <li>Tổng số thực thể: ${ACCOUNTS.totalElements}</li>--%>
<%--        <li>Tổng số trang: ${ACCOUNTS.totalPages}</li>--%>
<%--    </ul>--%>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</html>
