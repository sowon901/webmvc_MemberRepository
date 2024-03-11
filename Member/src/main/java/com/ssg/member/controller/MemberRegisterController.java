package com.ssg.member.controller;

import com.ssg.member.domain.MemberVO;
import com.ssg.member.dto.MemberDTO;
import com.ssg.member.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.now;

@WebServlet(name = "/memberForm", urlPatterns = "/member/addMember.do")
@Log4j2
public class MemberRegisterController extends HttpServlet {

    private MemberService ms = MemberService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if(session.isNew()) {
            response.sendRedirect("/memberLogin");
            return;
        }

        if(session.getAttribute("loginInfo")==null) {
            log.info("회원 정보가 없습니다.");
            response.sendRedirect("/memberLogin");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/member/memberForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MemberDTO dto = MemberDTO.builder()
                .id(request.getParameter("id"))
                .pwd(request.getParameter("pwd"))
                .name(request.getParameter("name"))
                .email(request.getParameter("email"))
                .date(now()).build();

        try {
            ms.addMember(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/member/listMembers.do");
    }
}
