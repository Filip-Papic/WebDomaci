<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Prijava članova</title>
    <%@include file="styles.jsp"%>
    <jsp:include page="hvala-na-prijavi.jsp"/>
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
        <jsp:useBean id="members" scope="session" class="rs.raf.demo.Clanovi" />

        <jsp:setProperty name="members" property="memberName" param="memberName" />
        <jsp:setProperty name="members" property="memberLastname" param="memberLastname" />
        <jsp:setProperty name="members" property="memberEmail" param="memberEmail" />
        <jsp:setProperty name="members" property="memberRole" param="memberRole" />
    </div>
</body>
</html>
