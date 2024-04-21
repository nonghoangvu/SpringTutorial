<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <style>
        .file-input {
            transition: all 0.3s ease-in-out;
        }

        .file-input:not(:last-child) {
            margin-bottom: 10px;
        }
    </style>

</head>
<body>
<div class="container m-5">
    <form action="/add" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Product Name</label>
            <input type="text" name="name" class="form-control" id="exampleFormControlInput1">
        </div>
        <div id="fileInputsContainer">
            <div class="input-group mb-3 file-input">
                <label class="input-group-text" for="inputGroupFile01">Upload</label>
                <input type="file" class="form-control" multiple name="files" id="inputGroupFile01">
                <button type="button" class="btn btn-outline-danger btn-sm" onclick="removeFileInput(this)"><i class="bi bi-trash"></i></button>
            </div>
        </div>
        <button class="btn btn-outline-success">Submit</button>
        <button type="button" onclick="addFileInput()" class="btn btn-outline-success">Add More Files</button>
    </form>
</div>


<script>
    function addFileInput() {
        const container = document.getElementById('fileInputsContainer');
        const newInput = document.createElement('div');
        newInput.classList.add('file-input');
        newInput.innerHTML = `
                <br>
             <div class="input-group mb-3">
                <label class="input-group-text" for="inputGroupFile01">Upload</label>
                <input type="file" class="form-control" multiple name="files" id="inputGroupFile01">
                <button type="button" class="btn-close" aria-label="Close" onclick="removeFileInput(this)"></button>
            </div>
            `;
        container.appendChild(newInput);
    }

    function removeFileInput(button) {
        button.parentNode.remove();
    }
</script>
</body>
</html>
