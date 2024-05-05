package core.princple.spring_core_principle.domain.member;

import core.princple.spring_core_principle.domain.member.model.Member;
import core.princple.spring_core_principle.domain.member.repository.MemberMemoryRepository;
import core.princple.spring_core_principle.domain.member.repository.MemberRepository;

import java.util.List;

public class MemberServiceImpl implements MemberService {

    private static MemberRepository repository = new MemberMemoryRepository();

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
