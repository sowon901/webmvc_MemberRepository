package com.ssg.member.controller;

import com.ssg.member.dto.MemberDTO;
import com.ssg.member.service.MemberService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="loginController", urlPatterns = "/memberLogin")
@Log
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/member/memberLogin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        try {
            MemberDTO dto = MemberService.INSTANCE.login(id,pwd);
            HttpSession session = request.getSession();

            session.setAttribute("loginInfo",dto);
            response.sendRedirect("/member/listMembers.do");

        } catch (Exception e) {
            response.sendRedirect("/memberLogin?result=error");
        }
    }

}
