<%--
  Created by IntelliJ IDEA.
  User: sowon
  Date: 2024-03-08
  Time: 오후 4:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <style>
        h1 {
            text-align:center;
        }


        div {
            align-content: center;
            text-align: center;
        }


    </style>
</head>
<body>
    <h1><b>회원정보</b></h1>
    <div>
    <table border = "1">
        <tr bgcolor="#a9a9a9">
            <td>아이디</td>
            <td>비밀번호</td>
            <td>이름</td>
            <td>이메일</td>
            <td>가입일</td>
            <td>수정</td>
            <td>삭제</td>
        </tr>
        <tr>
            <ul>
                <c:forEach items ="${list}" var="dto">
                    <tr>
                        <td>${dto.id}</td>
                        <td>${dto.pwd}</td>
                        <td>${dto.name}</td>
                        <td>${dto.email}</td>
                        <td>${dto.date}</td>
                        <td><a href="/member/modMember.do?id=${dto.id}">수정 </a></td>
                        <td><a href="/member/delMember.do?id=${dto.id}">삭제</a></td>
                    </tr>
                </c:forEach>
            </ul>
        </tr>
    </table>
    </div>
    <div align = "center">
        <p><a href="/member/addMember.do">회원 가입하기</a></p>
    </div>
</body>
</html>
