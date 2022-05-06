<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${post.getTitle()}</title>
    <%@ include file="styles.jsp"%>
</head>
<body style="background-color: #45a29e; color: #1f2833">
    <div class="container">
        <div class="row">
            <div class="col">
                <h1><b><c:out value="${post.getTitle()}" default='/'/></b></h1>
                <h6><fmt:formatDate pattern="dd/MM/yyyy" value="${post.getCreatedDate()}"/></h6>
                <h6><c:out value="${post.getAuthor()}" default='/'/></h6>
                <br>
                <p><c:out value="${post.getContent()}" default='/'/></p>
                <br>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col">
                <hr>
                <h2>Comments</h2>
                <hr>
                <c:if test="${commentList.isEmpty()}">
                    <h5>No comments</h5>
                </c:if>
                <c:forEach var="i" items="${commentList}">
                    <div>
                        <h4><c:out value="${i.getName()}"/></h4>
                        <p ><c:out value="${i.getBody()}"/></p>
                    </div>
                    <hr>
                </c:forEach>
                <br>
                <h5>New Comment</h5>
                <form method="post">
                    <div class="form-group">
                        <label for="commentName">Name</label>
                        <input type="text" class="form-control" name="commentName" id="commentName" placeholder="Enter name">
                    </div>
                    <div class="form-group">
                        <label for="commentBody">Comment</label>
                        <input type="text" class="form-control" name="commentBody" id="commentBody" placeholder="Enter comment">
                    </div>
                    <button type="submit" class="btn btn-primary">Comment</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
