package core.princple.spring_core_principle.domain.member.repository;

import core.princple.spring_core_principle.domain.member.model.Member;

import java.util.Collections;
import java.util.Set;

public final class MemberDatabaseRepository implements MemberRepository {

    @Override
    public Member findByTarget(String unique) {
        return null;
    }

    @Override
    public Set<Member> findAll() {
        return Collections.emptySet();
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
