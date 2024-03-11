package com.ssg.member.controller;

import com.ssg.member.domain.MemberVO;
import com.ssg.member.dto.MemberDTO;
import com.ssg.member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="memberDeleteController", urlPatterns = "/member/delMember.do")
public class MemberDeleteController extends HttpServlet {

    private MemberService ms = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        try {
            ms.remove(id);
        }catch(Exception e) {
            throw new ServletException("삭제 에러");
        }
        response.sendRedirect("/member/listMembers.do");
    }


}
