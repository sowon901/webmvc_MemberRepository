package com.ssg.member.controller;

import com.ssg.member.dao.MemberDAO;
import com.ssg.member.dto.MemberDTO;
import com.ssg.member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="memberController", urlPatterns="/member/listMembers.do")
public class MemberController extends HttpServlet {

    private MemberService ms = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<MemberDTO> dto = ms.showList();
            request.setAttribute("list",dto);
            request.getRequestDispatcher("/WEB-INF/member/listMembers.jsp").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("리스트를 불러올 수 없습니다.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MemberDTO dto = new MemberDTO();

        try {
            String id = request.getParameter("id");
            dto.setId(id);
            request.setAttribute("id", id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("리스트 확인 에러");
        }

        response.sendRedirect("/member/modMember.do");
    }
}
