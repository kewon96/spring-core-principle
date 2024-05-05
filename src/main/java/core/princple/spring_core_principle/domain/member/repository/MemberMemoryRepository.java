package core.princple.spring_core_principle.domain.member.repository;

import core.princple.spring_core_principle.domain.member.model.Member;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class MemberMemoryRepository implements MemberRepository {

    /**
     * Memory에 저장할 Map
     * Key의 기준은 Email로 지정
     *
     * 동시성이슈를 막고자 HashMap이 아닌 CuncurrentMap을 사용함
     */
    private static ConcurrentMap<UUID, Member> store = new ConcurrentHashMap<>();


    @Override
    public Member findByTarget(String id) {
        return store.get(UUID.fromString(id));
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }

    @Override
    public void add(Member member) {
        assert member != null;

        store.putIfAbsent(member.id(), member);
    }

    @Override
    public void update(Member member) {

    }

    @Override
    public void delete(Member member) {

    }
}
