<%--
  Created by IntelliJ IDEA.
  User: sowon
  Date: 2024-03-08
  Time: 오후 4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        h1 {
            text-align:center;
        }

        div {
            text-align: center;
            padding-bottom: 10px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

    </style>
</head>
<body>
<form action="/member/addMember.do" method="post">
    <div>
        <h1><b>회원 가입</b></h1>
    </div>
        <div>
            <h3>아이디</h3>
            <input type="text" name="id">
        </div>
        <div>
            <h3>비밀번호</h3>
            <input type="password" name="pwd" >
        </div>
        <div>
            <h3>이름</h3>
            <input type="text" name="name">
        </div>
        <div>
            <h3>이메일</h3>
            <input type="email" name="email">
        </div>
    <div>
        <p>
        <button type="submit">가입하기</button>
        <button type="reset">다시입력</button>
        </p>
    </div>
</form>
</body>
</html>