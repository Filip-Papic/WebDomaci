<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Prijava tima</title>
    <%@include file="styles.jsp"%>
    <jsp:include page="prijavaClanova.jsp"/>
</head>
<body>
    <div class="container">
        <%--Kreiranje instance bean-a. Scope:
        application - instanca beana je dostupna celoj web aplikaciji
        session - instanca beana se kreira za svaku novu sesiju
        request - instanca beana se kreira kada stigne novi zahtev i dostupna je samo na nivou tog zahteva
        sto znaci da ce biti dostupan i drugim stranicama, na primer ako uradimo
         <jsp:forward page="stranica.jsp"/> ili <jsp:include page="stranica.jsp"/>
        page - instanca beana je dostupna samo jednoj jsp stranici --%>
        <jsp:useBean id="team" scope="session" class="rs.raf.demo.Tim" />

        <jsp:setProperty name="team" property="teamName" param="teamName" />
        <jsp:setProperty name="team" property="email" param="email" />
        <jsp:setProperty name="team" property="phone" param="phone" />
        <jsp:setProperty name="team" property="moto" param="moto" />
        <jsp:setProperty name="team" property="heardFrom" param="heardFrom" />
        <jsp:setProperty name="team" property="teamSize" param="teamSize" />
        <jsp:setProperty name="team" property="registered" param="registered" />

    </div>
</body>
</html>
