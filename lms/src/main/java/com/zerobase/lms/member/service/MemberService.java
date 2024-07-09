package com.zerobase.lms.member.service;

import com.zerobase.lms.member.model.MemberInput;
import com.zerobase.lms.member.model.ResetPasswordInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    boolean register(MemberInput parameter);

    /**
     * uui에 해당하는 계정 활성화
     * @param uuid
     * @return
     */
    boolean emailAuth(String uuid);

    /**
     * 입력한 이메일로 비밀번호 초기화 정보 전송
     * @param parameter
     * @return
     */
    boolean sendResetPassword(ResetPasswordInput parameter);
}
