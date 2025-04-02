package com.nr.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentSportResponse {
    private Long id;
    private String sportName;
    private String participationDate;
    private String result;
}
