package core.princple.spring_core_principle.domain.member.repository;

import core.princple.spring_core_principle.domain.member.model.Member;

import java.util.List;

public final class MemberDatabaseRepository implements MemberRepository {

    @Override
    public Member findByTarget(String unique) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }

    @Override
    public void add(Member member) {

    }

    @Override
    public void update(Member member) {

    }

    @Override
    public void delete(Member member) {

    }
}
