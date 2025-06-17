package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberRepository;
import com.example.demo.domain.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

        memberRepository.save(member);
        return member.getId();
    }

    public Member findOne(Long saveId) {
        return memberRepository.findById(saveId).orElse(null);
    }

    public List<Member> findMembers() {
        System.out.println("Hello");
        return memberRepository.findAll();
    }
}
