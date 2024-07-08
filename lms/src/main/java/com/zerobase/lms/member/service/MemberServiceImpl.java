package com.zerobase.lms.member.service;

import com.zerobase.lms.member.entity.Member;
import com.zerobase.lms.member.model.MemberInput;
import com.zerobase.lms.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public boolean register(MemberInput parameter) {

        Optional<Member> optionalMember =
                memberRepository.findById(parameter.getUserId());
        if(optionalMember.isPresent()) {
            // 동일한 데이터 존재
             return false;
        }

        Member member = new Member();

        member.setUserId(parameter.getUserId());
        member.setUserName(parameter.getUserName());
        member.setPhone(parameter.getPhone());
        member.setPassword(parameter.getPassword());
        member.setRegisterTime(LocalDateTime.now());

        memberRepository.save(member);
        return false;
    }
}
