<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Prijava</title>
    <%@include file="styles.jsp"%>
    <jsp:useBean id="team" scope="session" class="rs.raf.demo.Tim" />
</head>
<body class="u-section-2" style="position: absolute;text-align: center;top: 50%;left: 50%;transform: translate(-50%, -50%)">

<%
    //if (team.getRegistered() != null && team.getRegistered().equals("true")) {
    if(request.getSession().getAttribute("valid") != null && request.getSession().getAttribute("valid").equals("true")) {
%>
    <h1 style="color: red"> Prijava već kreirana!! </h1>
<%
} else {
%>
    <div class="container">
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
                <div class="u-custom-font u-font-monoton u-text u-text-body-alt-color neon">
                    <h1>Prijava</h1>
                    <form class="form-horizontal" action="/submitTim" method="POST">
                        <div class="form-group">
                            <label for="teamName">Naziv tima</label>
                            <input type="text" class="form-control" id="teamName" name="teamName" aria-describedby="emailHelp">
                        </div>
                        <div class="form-group">
                            <label for="email">Kontakt email</label>
                            <input type="text" class="form-control" id="email" name="email" aria-describedby="emailHelp">
                        </div>
                        <div class="form-group">
                            <label for="phone">Kontakt telefon</label>
                            <input type="text" class="form-control" id="phone" name="phone" aria-describedby="emailHelp">
                        </div>
                        <div class="form-group">
                            <label for="moto">Moto tima</label>
                            <input type="text" class="form-control" id="moto" name="moto" aria-describedby="emailHelp">
                        </div>
                        <div class="form-group">
                            <label for="heardFrom">Kako ste čuli za hakaton?</label>
                            <select name="heardFrom" id="heardFrom" style="background-color: black">
                                <option value="facebook">Facebook</option>
                                <option value="instagram">Instagram</option>
                                <option value="twitter">Twitter</option>
                                <option value="kolege">Od kolega</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="teamSize">Broj članova tima</label>
                            <select name="teamSize" id="teamSize" style="background-color: black">
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>
                        </div>
                        <input class="u-active-white u-border-2 u-border-white u-btn u-button-style u-hover-white u-none u-text-active-black u-text-body-alt-color u-text-hover-black u-btn-6 text-outline" type="submit" value="Članovi">
                    </form>
                </div>
            </div>
        </div>
    </div
<%
    }
%>
</body>
</html>
