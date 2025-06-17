package com.example.demo.domain;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    public void save(Member member) {
        member.setId(++sequence);  // assign a new id
        store.put(member.getId(), member);
    }

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Optional<Member> findByName(String name) {
        // Search the store for a member with the matching name
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
        sequence = 0L;  // reset sequence after clearing
    }
}
