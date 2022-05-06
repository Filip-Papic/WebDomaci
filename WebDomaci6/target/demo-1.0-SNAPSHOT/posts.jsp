<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Public Blog</title>
    <%@ include file="styles.jsp"%>
</head>
<body style="background-color: #45a29e; color: #66fcf1">
    <div class="container">
        <h2 style="color: #1f2833"><b>Posts</b></h2>
        <c:forEach var="i" items="${posts}">
            <div class="card" style="width: 18rem; background-color: #1f2833">
                <div class="card-body">
                    <h5 class="card-title">${i.getTitle()} </h5>
                    <p class="card-text">${i.getContent()}</p>
                    <a href="${pageContext.request.contextPath}/posts/${i.getPostID()}" class="stretched-link"></a>
                </div>
            </div>
            <hr>
        </c:forEach>
        <form action="<c:url value="/new-post"/>" method="get">
            <button class="btn btn-primary" type="submit">New Post</button>
        </form>
    </div>
</body>
</html>
