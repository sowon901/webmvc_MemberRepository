package com.ssg.member.controller;

import com.ssg.member.dto.MemberDTO;
import com.ssg.member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name="memberModifyController", urlPatterns = "/member/modMember.do")
public class MemberModifyController extends HttpServlet {

    private MemberService ms = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            MemberDTO dto = ms.showOne(id);
            request.setAttribute("dto", dto);
            request.getRequestDispatcher("/WEB-INF/member/modifyMembers.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("수정 에러");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MemberDTO dto;

        dto = MemberDTO.builder()
                .id(request.getParameter("id"))
                .pwd(request.getParameter("pwd"))
                .name(request.getParameter("name"))
                .email(request.getParameter("email"))
                .build();

        try {
            ms.modify(dto);
        } catch (Exception e) {
            throw new ServletException("수정 불가");
        }

        response.sendRedirect("/member/listMembers.do");

    }


}
