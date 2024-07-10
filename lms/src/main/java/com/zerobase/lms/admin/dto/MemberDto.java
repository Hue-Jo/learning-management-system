package com.zerobase.lms.admin.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberDto {

    String userId;
    String userName;
    String phone;
    String password;
    LocalDateTime registerTime;

    boolean emailAuthYn;
    LocalDateTime emailAuthDate;
    String emailAuthKey;

    String resetPasswordKey;
    LocalDateTime resetPasswordLimitDt;

    boolean adminYn;

    long totalCount;
    long seq;
}
