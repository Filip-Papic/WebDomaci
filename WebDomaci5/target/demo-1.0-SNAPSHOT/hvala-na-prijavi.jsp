<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hvala na prijavi</title>
    <%@include file="styles.jsp"%>
    <jsp:useBean id="team" scope="session" class="rs.raf.demo.Tim" />
</head>
<body class="u-section-2" style="position: absolute;text-align: center;top: 50%;left: 50%;transform: translate(-50%, -50%)">
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
                <div class="u-custom-font u-font-monoton u-text u-text-body-alt-color neon" style="align-content: center">
                    <div class="row col-6 mx-auto text-center justify-content-center">
<%--
                        <h1><jsp:getProperty name="team" property="teamName"/>, hvala na prijavi!</h1>
--%>                    <h1><%= request.getSession().getAttribute("teamName") %> , hvala na prijavi!</h1>
                        <h2>Naš tim pregleda prijavu i obavestiće vas o konačnoj odluci do 11. decembra na email:</h2>
<%--
                        <h2 class="neonNoFlicker"><jsp:getProperty name="team" property="email"/></h2>
--%>
                        <h2 class="neonNoFlicker"><%= request.getSession().getAttribute("email") %> </h2>
                        <h3>Za sva dodatna pitanja možete pisati na: hakaton@raf.rs</h3>
<%--
                        <jsp:setProperty name="team" property="registered" value="true" />
--%>
                    </div>
                </div>
                <br><br>
            </div>
        </div>
    </div>
</body>
</html>
