package com.example.demo;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemoryMemberRepository;
import com.example.demo.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

// MemberServiceTest.java
public class MemberServiceTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    MemberService memberService = new MemberService(repository);

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void join() {
        Member member = new Member(null, "spring");

        Long saveId = memberService.join(member);

        Member findMember = memberService.findOne(saveId).get();
        assertThat(findMember.getName()).isEqualTo("spring");
    }

    @Test
    void duplicateJoinThrowsException() {
        Member member1 = new Member(null, "spring");
        Member member2 = new Member(null, "spring");

        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
