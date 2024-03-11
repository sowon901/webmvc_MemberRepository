<%--
  Created by IntelliJ IDEA.
  User: sowon
  Date: 2024-03-10
  Time: 오후 7:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>

        span {
            text-align: center;
        }

        h1{
            text-align: center;
        }

        div {
            text-align: center;
            padding-bottom: 15px;
        }

    </style>
</head>
<body>
    <c:if test="${param.result == 'error'}">
        <span hidden="hidden" style= "color: red" >
            <h1>로그인 에러입니다. 다시 시도하세요</h1>
        </span>
    </c:if>
    <form action="/memberLogin" method="post">
        <h1>로그인</h1>

            <div>
                <h3>아이디</h3>
                <input type="text" name="id">
            </div>
            <div>
                <h3>비밀번호</h3>
                <input type="password" name="pwd" >
            </div>
        <div>
            <button type="submit">로그인</button>
            <button type="reset">다시입력</button>
        </div>
</form>
</body>
</html>
