package com.ssg.member.dao;

import com.ssg.member.domain.MemberVO;
import com.ssg.member.dto.MemberDTO;
import com.ssg.member.util.ConnectionUtil;
import lombok.*;
import org.modelmapper.internal.bytebuddy.dynamic.scaffold.MethodRegistry;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    String now = null;

    public String time() throws Exception{

        String sql = "select now()";

        @Cleanup
        Connection con = ConnectionUtil.Instance.getConnection();
        @Cleanup
        PreparedStatement ps = con.prepareStatement(sql);
        @Cleanup
        ResultSet rs = ps.executeQuery();
        rs.next();
        now = rs.getString(1);

        return now;
    }

    public MemberVO getMembers(String id, String pwd) throws Exception{

        String sql = "select * from mvc_member " +
                "where 아이디 = ? and 비밀번호 = ?";

        MemberVO vo;

        @Cleanup
        Connection con = ConnectionUtil.Instance.getConnection();
        @Cleanup
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        ps.setString(2,pwd);

        @Cleanup
        ResultSet rs = ps.executeQuery();

        rs.next();

        vo = MemberVO.builder().id(rs.getString(1))
                .pwd(rs.getString(2))
                .name(rs.getString(3))
                .email(rs.getString(4))
                .date(rs.getDate(5).toLocalDate()).build();

        return vo;
    }

    public void addMember(MemberVO vo) throws Exception{

        String sql = "insert into mvc_member(아이디, 비밀번호, 이름, 이메일, 가입일)" +
                "values(?,?,?,?,?)";

        @Cleanup
        Connection con = ConnectionUtil.Instance.getConnection();
        @Cleanup
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,vo.getId());
        ps.setString(2,vo.getPwd());
        ps.setString(3,vo.getName());
        ps.setString(4,vo.getEmail());
        ps.setDate(5, Date.valueOf(vo.getDate()));

        ps.executeUpdate();
    }


    public List<MemberVO> listMembers() throws Exception {

        String sql = "select * from mvc_member";

        List<MemberVO> voList = new ArrayList<>();
        @Cleanup
        Connection con = ConnectionUtil.Instance.getConnection();
        @Cleanup
        PreparedStatement ps = con.prepareStatement(sql);
        @Cleanup
        ResultSet rs = ps.executeQuery();
        int count= 0;
        while(rs.next()) {
            MemberVO vo;
            vo = MemberVO.builder().id(rs.getString("아이디"))
                    .pwd(rs.getString("비밀번호"))
                    .name(rs.getString("이름"))
                    .email(rs.getString("이메일"))
                    .date(rs.getDate("가입일").toLocalDate()).build();
            voList.add(vo);
            count++;
        }
        con.close();

        return voList;
      }

      public MemberVO showOneMember(String id) throws Exception{

        String sql = "select * from mvc_member where 아이디 = ?";
        MemberVO vo;

        @Cleanup
        Connection con = ConnectionUtil.Instance.getConnection();
        @Cleanup
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);

        @Cleanup
        ResultSet rs = ps.executeQuery();
        rs.next();

        vo = MemberVO.builder().id(rs.getString("아이디"))
                .pwd(rs.getString("비밀번호"))
                .name(rs.getString("이름"))
                .email(rs.getString("이메일"))
                .date(rs.getDate("가입일").toLocalDate()).build();

          System.out.println(vo.toString());

        return vo;
      }

    public void deleteMember(String id) throws Exception{
        String sql = "delete from mvc_member where 아이디 = ?";
        @Cleanup
        Connection con = ConnectionUtil.Instance.getConnection();

        @Cleanup
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        ps.executeUpdate();
    }

    public void modifyMember(MemberVO vo) throws Exception{

        String sql = "update mvc_member set 비밀번호 = ?, 이름 = ?, 이메일 = ? where 아이디 = ?";
        @Cleanup
        Connection con = ConnectionUtil.Instance.getConnection();

        @Cleanup
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1,vo.getPwd());
        ps.setString(2,vo.getName());
        ps.setString(3,vo.getEmail());
        ps.setString(4,vo.getId());

        ps.executeUpdate();
    }
}
