package com.ssg.member.service;

import com.ssg.member.dao.MemberDAO;
import com.ssg.member.domain.MemberVO;
import com.ssg.member.dto.MemberDTO;
import com.ssg.member.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {

    INSTANCE;
    private MemberDAO dao;
    private ModelMapper mapper;

    MemberService() {
        dao = new MemberDAO();
        mapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String id, String pw) throws Exception {
        MemberVO vo = dao.getMembers(id, pw);
        MemberDTO dto = mapper.map(vo, MemberDTO.class);

        return dto;
    }

    public void addMember(MemberDTO dto) throws Exception {
        MemberVO vo = mapper.map(dto,MemberVO.class);
        dao.addMember(vo);
    }

    public List<MemberDTO> showList() throws Exception{
        List<MemberVO> voList = dao.listMembers();

        List<MemberDTO> dtoList = voList.stream().map(vo->mapper.map(vo, MemberDTO.class)).collect(Collectors.toList());

        return dtoList;
    }

    public MemberDTO showOne(String id) throws Exception{
        MemberDTO dto;

        MemberVO vo = dao.showOneMember(id);

        dto = mapper.map(vo, MemberDTO.class);

        return dto;
    }

    public void remove(String id) throws Exception{
        dao.deleteMember(id);
    }

    public void modify(MemberDTO dto) throws Exception{

        MemberVO vo = mapper.map(dto, MemberVO.class);
        dao.modifyMember(vo);
    }

}
