<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Članovi</title>
    <%@include file="styles.jsp"%>
<%--
    <jsp:useBean id="team" scope="session" class="rs.raf.demo.Tim" />
--%>
</head>
<body class="u-section-2" >

<div class="container" style="display: flex;justify-content: center;align-items: center;">
    <div class="row">
    <div class="span12">
        <div>
            <p class="u-large-text u-text u-text-body-alt-color u-text-font u-text-variant">
                <a href="<%=application.getContextPath()%>/#hero" class="u-active-none u-border-none u-btn u-button-link u-button-style u-hover-none u-none u-text-body-alt-color u-btn-1 text-outline">Početna</a> |
                <a href="<%=application.getContextPath()%>/#details" class="u-active-none u-border-none u-btn u-button-link u-button-style u-hover-none u-none u-text-body-alt-color u-btn-1 text-outline">O takmičenju</a> |
                <a href="<%=application.getContextPath()%>/#prizes" class="u-active-none u-border-none u-btn u-button-link u-button-style u-hover-none u-none u-text-body-alt-color u-btn-2 text-outline"><span class="flicker-slower">Nagrade</span></a> |
                <a href="<%=application.getContextPath()%>/#partners" class="u-active-none u-border-none u-btn u-button-link u-button-style u-hover-none u-none u-text-body-alt-color u-btn-3 text-outline">Partneri</a>
            </p>
        </div>
        <br>
        <div class="u-text-body-alt-color neonNoFlicker" style="text-align: center; align-items: center;">
            <h1 style="text-align: center">Prijava članova</h1>
            <form class="overflow-hidden" action="/submitClanovi" method="POST" style="">
                <%
                //for(int i = 1; i < team.getTeamSize()+1; i++){
                    for(int i = 1; i < (int) request.getSession().getAttribute("teamSize")+1; i++){
                %>
                <div class="justify-content-center form-group row">
                    <label for="memberName" class="col-sm-2 col-form-label">Ime člana</label>
                    <div class=col-sm-10">
                        <input type="text" class="form-control" id="memberName" name="memberName<%=i%>" aria-describedby="emailHelp">
                    </div>
                </div>
                <div class="justify-content-center form-group row">
                    <label for="memberLastname" class="col-sm-2 col-form-label">Prezime člana</label>
                    <div class=col-sm-10">
                        <input type="text" class="form-control" id="memberLastname" name="memberLastname<%=i%>" aria-describedby="emailHelp">
                    </div>
                </div>
                <div class="justify-content-center form-group row">
                    <label for="memberEmail" class="col-sm-2 col-form-label">Email člana</label>
                    <div class=col-sm-10">
                        <input type="text" class="form-control" id="memberEmail" name="memberEmail<%=i%>" aria-describedby="emailHelp">
                    </div>
                </div>
                <div class="justify-content-center form-group row" >
                    <label for="memberRole" class="col-sm-2 col-form-label">Uloga</label>
                    <div class=col-sm-10">
                        <input type="text" class="form-control" id="memberRole" name="memberRole<%=i%>" aria-describedby="emailHelp">
                    </div>
                </div>
                <hr class="rounded neon" style="border-top: 8px solid #D42CCA; border-radius: 5px">
                <%
                    }
                %>
                <div class="row justify-content-center">
                    <input class="u-active-white u-border-2 u-border-white u-btn u-button-style u-hover-white u-none u-text-active-black u-text-body-alt-color u-text-hover-black u-btn-6 text-outline" type="submit" value="Prijavi tim!">
                </div>
            </form>
        </div>
    </div>
    </div>
</div>
</body>
</html>
