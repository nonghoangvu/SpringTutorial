<%--
  Created by IntelliJ IDEA.
  User: NONG HOANG VU
  Date: 4/21/2024
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<form action="/upload" method="post" enctype="multipart/form-data">
    <div id="fileInputsContainer">
        <div class="file-input">
            <input type="file" name="files" multiple>
            <button type="button" class="remove-file-btn" onclick="removeFileInput(this)">Remove</button>
        </div>
    </div>
    <button type="button" onclick="addFileInput()">Add More Files</button>
    <button type="submit">Upload</button>
</form>

<script>
    function addFileInput() {
        const container = document.getElementById('fileInputsContainer');
        const newInput = document.createElement('div');
        newInput.classList.add('file-input');
        newInput.innerHTML = `
                <input type="file" name="files" multiple>
                <button type="button" class="remove-file-btn" onclick="removeFileInput(this)">Remove</button>
            `;
        container.appendChild(newInput);
    }

    function removeFileInput(button) {
        button.parentNode.remove();
    }
</script>
</body>
</html>
