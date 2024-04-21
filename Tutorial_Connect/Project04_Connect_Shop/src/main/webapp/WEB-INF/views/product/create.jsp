<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-secondary text-uppercase m-3">New Product</h1>
<div class="container-sm m-5 align-middle">
    <form:form modelAttribute="product" action="/product/add" method="post" enctype="multipart/form-data">
        <form:errors path="*" element="div" cssClass="alert alert-danger"></form:errors>
        <div class="row m-5 align-items-center g-2">
            <div class="col-md-12">
                <div class="row row-cols-2 mb-3 align-items-center">
                    <div class="col-2">
                        <label class="label-form">Name:</label>
                    </div>
                    <div class="col">
                        <form:input path="productName" type="text" class="form-control" placeholder="Enter product name"/>
                    </div>
                </div>
                <div class="row row-cols-2 mb-3 align-items-center">
                    <div class="col-2">
                        <label class="label-form">Price:</label>
                    </div>
                    <div class="col">
                        <form:input path="price" type="number" class="form-control" placeholder="Enter product price"/>
                    </div>
                </div>
                <div class="row row-cols-2 mb-3">
                    <div class="col-2">
                        <label class="label-form">Description:</label>
                    </div>
                    <div class="col">
                        <form:textarea path="description" class="form-control" rows="3" placeholder="Enter product description"></form:textarea>
                    </div>
                </div>
                <div class="row row-cols-2 mb-3 align-items-center">
                    <div class="col-2">
                        <label class="label-form">Image:</label>
                    </div>
                    <div class="col">
                        <input name="photo" type="file" class="form-control" multiple placeholder="Upload product image">
                    </div>
                </div>
            </div>
        </div>
        <div class="text-center">
            <a href="/product" class="btn btn-outline-danger">Back</a>
            <button class="btn btn-outline-secondary">Save</button>
        </div>
    </form:form>
</div>
