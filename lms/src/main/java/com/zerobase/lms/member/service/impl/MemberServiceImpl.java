package com.zerobase.lms.member.service.impl;

import com.zerobase.lms.component.MailComponent;
import com.zerobase.lms.member.entity.Member;
import com.zerobase.lms.member.model.MemberInput;
import com.zerobase.lms.member.repository.MemberRepository;
import com.zerobase.lms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MailComponent mailComponent;

    @Override
    public boolean register(MemberInput parameter) {

        Optional<Member> optionalMember =
                memberRepository.findById(parameter.getUserId());
        if(optionalMember.isPresent()) {
            // 동일한 데이터 존재
             return false;
        }

        String uuid = UUID.randomUUID().toString();
        Member member = new Member();

        member.setUserId(parameter.getUserId());
        member.setUserName(parameter.getUserName());
        member.setPhone(parameter.getPhone());
        member.setPassword(parameter.getPassword());
        member.setRegisterTime(LocalDateTime.now());

        member.setEmailAuthYn(false);
        member.setEmailAuthKey(uuid);

        memberRepository.save(member);

        String email = parameter.getUserId();
        String subject = "LMS 사이트 가입을 축하드립니다 :) ";
        String text = "<p> Zerobase LMS 사이트 가입을 축하드립니다. </p>" +
                "<p> 아래 링크를 클릭하셔서 가입을 완료하세요! </p>" +
                "<div><a href='http://localhost:8080/member/email-auth?id=" + uuid + "'> 여기를 누르세요 </a> </div>";
        mailComponent.sendMail(email,subject,text);
        return true;
    }

    @Override
    public boolean emailAuth(String uuid) {
        Optional<Member> optionalMember = memberRepository.findByEmailAuthKey(uuid);
        if(!optionalMember.isPresent()) {
            return false;
        }
        Member member = optionalMember.get();
        member.setEmailAuthYn(true);
        member.setEmailAuthDate(LocalDateTime.now());
        memberRepository.save(member);

        return true;
    }
}
