package com.ssg.member.dto;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class MemberDTO {

    private String id;
    private String pwd;
    private String name;
    private String email;
    private LocalDate date;

}
