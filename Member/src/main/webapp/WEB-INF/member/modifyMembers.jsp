<%--
  Created by IntelliJ IDEA.
  User: sowon
  Date: 2024-03-10
  Time: 오후 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ModifyPage</title>
</head>
<body>
<form action="/member/modMember.do" method="post">
    <label>
        <div>
            <input type="text" name ="id" value="${dto.id}" readonly>
        </div>
        <div>
            <input type="text" name="pwd" value="${dto.pwd}" >
        </div>
        <div>
            <input type="text" name="name" value="${dto.name}" >
        </div>
        <div>
            <input type="email" name="email" value="${dto.email}">
        </div>
        <div>
            <input type="date" name="date" value="${dto.date}" readonly>
        </div>
        <div>
            <button type = "submit">수정하기</button>
        </div>
    </label>
</form>

</body>
</html>
