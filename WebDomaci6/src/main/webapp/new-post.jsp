<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>New Post</title>
    <%@ include file="styles.jsp"%>
</head>
<body style="background-color: #45a29e; color: #1f2833">
    <div class="container">
        <h2><b>New post</b></h2>
        <form method="post">
            <div class="form-group">
                <label for="postAuthor">Author</label>
                <input type="text" class="form-control" name="postAuthor" id="postAuthor" placeholder="Enter name">
            </div>
            <div class="form-group">
                <label for="postTitle">Title</label>
                <input type="text" class="form-control" name="postTitle" id="postTitle" placeholder="Enter title">
            </div>
            <div class="form-group">
                <label for="postContent">Content</label>
                <input type="text" class="form-control" name="postContent" id="postContent" placeholder="Enter post content">
            </div>
            <button type="submit" class="btn btn-primary">Save Post</button>
        </form>
    </div>
</body>
</html>
