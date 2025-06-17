package com.example.demo;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member(null, "spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
        Member member1 = new Member(null, "spring1"); // create with final name
        repository.save(member1);

        Member member2 = new Member(null, "spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        Member member1 = new Member(null,"spring");
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(null,"spring");
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
