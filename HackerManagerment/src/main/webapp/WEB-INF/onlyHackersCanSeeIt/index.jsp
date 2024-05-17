<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hacker Here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script defer src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body class="bg-black">
<div class="container">
    <h1 class="text-center text-uppercase text-success mt-3">Hacker management demo version</h1>
    <p class="text-center text-warning">Currently, the id existence check function is active and you will not be able to
        update</p>
    <p class="text-center text-info">If you want to update, you must go to entity Hacker and comment line 17</p>
    <form:form method="post" class="row" modelAttribute="hacker">
        <div class="mb-3 col-3">
            <label class="form-label text-success">ID</label>
            <form:input
                    path="id"
                    class="form-control text-success bg-transparent border-success d-inline-flex focus-ring focus-ring-dark py-1 px-2 text-decoration-none border rounded-2"
                    name="id"
                    id="id"
            />
            <form:errors
                    cssClass="text-danger"
                    path="id"
                    element="label"
            />
        </div>
        <div class="mb-3 col-9">
            <label class="form-label text-success">Full name</label>
            <form:input
                    path="fullName"
                    type="text"
                    class="form-control text-success bg-transparent border-success d-inline-flex focus-ring focus-ring-dark py-1 px-2 text-decoration-none border rounded-2"
                    name="fullName"
            />
            <form:errors
                    cssClass="text-danger"
                    path="fullName"
                    element="label"
            />
        </div>
        <div class="mb-3 col-3">
            <label class="form-label text-success">Gender</label>
            <br>
            <div class="form-check form-check-inline">
                <form:radiobutton
                        path="gender"
                        class="form-check-input
                        bg-transparent border-success d-inline-flex focus-ring focus-ring-dark py-1 px-2 text-decoration-none border rounded-2"
                        name="gender"
                        value="true"
                />
                <label class="form-check-label text-success">Male</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton
                        path="gender"
                        class="form-check-input bg-transparent border-success d-inline-flex focus-ring focus-ring-dark py-1 px-2 text-decoration-none border rounded-2"
                        name="gender"
                        value="false"
                />
                <label class="form-check-label text-success">Female</label>
            </div>
            <form:errors
                    cssClass="text-danger"
                    path="gender"
                    element="label"
            />
        </div>
        <div class="mb-3 col-9">
            <label class="form-label text-success">Major</label>
            <form:select path="major"
                         cssClass="form-select bg-transparent text-success border-success d-inline-flex focus-ring focus-ring-dark py-1 px-2 text-decoration-none border rounded-2">
                <option value="" selected>Open this select menu</option>
                <form:options items="${listMajor}"/>
            </form:select>
            <form:errors cssClass="text-danger" path="major" element="label"/>
        </div>
        <div class="col mb-3">
            <button class="btn btn-outline-success" formaction="/hacker/store">Save</button>
            <button class="btn btn-outline-success" formaction="/hacker/update">Update</button>
        </div>
    </form:form>
    <div>
        <form action="/hacker">
            <label class="form-label text-success">
                Search
                <input
                        type="search"
                        class="mb-3 form-control bg-transparent text-success border-success d-inline-flex focus-ring focus-ring-dark py-1 px-2 text-decoration-none border rounded-2"
                        name="keyword"
                        placeholder="Enter the hacker name..."
                        value="${keyword}"
                >
            </label>
        </form>
        <c:if test="${not empty hackers}">
            <table class="table text-center border-success table-bordered">
                <thead>
                <tr>
                    <th colspan="5" class="bg-transparent text-white-50 text-uppercase h1">
                        <i class="bi bi-fingerprint text-success"></i>
                        Top number one hackers in the world in 2024
                        <i class="bi bi-shield-exclamation text-success"></i>
                    </th>
                </tr>
                <tr>
                    <th class="bg-transparent text-success" scope="col">ID</th>
                    <th class="bg-transparent text-success" scope="col">FullName</th>
                    <th class="bg-transparent text-success" scope="col">Gender</th>
                    <th class="bg-transparent text-success" scope="col">Major</th>
                    <th class="bg-transparent text-success" scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="x" items="${hackers}">
                    <tr>
                        <th class="bg-transparent text-success" scope="row">${x.id}</th>
                        <td class="bg-transparent text-success text-start">${x.fullName eq 'Nong Hoang Vu' ? '<i class="bi bi-award-fill text-warning">Top 1</i>' : ""} ${x.fullName}</td>
                        <td class="bg-transparent ${x.gender ? "text-info" : "text-light"} text-start">${x.gender ? '<i class="bi bi-gender-female"></i> Male' : '<i class="bi bi-gender-male"></i> Female'}</td>
                        <td class="bg-transparent text-success text-start">${x.major}</td>
                        <td class="bg-transparent text-success">
                            <button class="btn btn-outline-success" onclick="del(${x.id})">Delete
                            </button>
                            <a class="btn btn-outline-success" href="/hacker/${x.id}">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty hackers}">
            <h1 class="text-warning text-uppercase text-center"><i class="bi bi-exclamation-triangle-fill"></i> Data is
                empty!</h1>
        </c:if>
        <strong class="position-fixed start-0 top-0 text-secondary " id="copyright"></strong>
        <button
                id="goTop"
                onclick="backHome()"
                class="position-fixed end-0 bottom-0 m-5 bg-transparent text-secondary opacity-50 border-0 fw-bold rounded-circle h1"
        >
            <i class="bi bi-arrow-up-circle-fill"></i>
        </button>
        <footer class="text-center m-5">
            <i class="text-light">©Copyright Nong Hoang Vu - 2024</i>
        </footer>
    </div>
    <script>
        const inputID = document.getElementById("id")
        const goTop = document.getElementById('goTop')
        const copyright = document.getElementById('copyright')
        goTop.style.display = 'none'
        inputID.addEventListener('input', () => {
            if (inputID.type !== 'number') {
                inputID.type = 'number'
            }
        })
        window.addEventListener('scroll', () => {
            if (window.scrollY >= 200) {
                goTop.style.display = ''
                if (window.scrollY >= 1000) {
                    copyright.innerText = 'Hi! My name is Mr.Vuz'
                }
            } else {
                copyright.innerText = ''
                goTop.style.display = 'none'
            }
        })
        const backHome = () => {
            window.scroll({top: 0, behavior: 'smooth'})
        }

        const del = (id) => {
            swal('Good', 'Hacker has been deleted', 'success').then(() => {
                window.location.href = '/hacker/delete/' + id
            })
        }
    </script>
</div>
</body>
</html>
