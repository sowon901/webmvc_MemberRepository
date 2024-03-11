package com.ssg.member.domain;
import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class MemberVO {

    private String id;
    private String pwd;
    private String name;
    private String email;
    private LocalDate date;


}
