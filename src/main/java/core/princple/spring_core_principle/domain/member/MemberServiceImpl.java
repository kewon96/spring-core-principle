package core.princple.spring_core_principle.domain.member;

import core.princple.spring_core_principle.domain.member.model.Member;
import core.princple.spring_core_principle.domain.member.repository.MemberMemoryRepository;
import core.princple.spring_core_principle.domain.member.repository.MemberRepository;

import java.util.Set;


public class MemberServiceImpl implements MemberService {

    private static MemberRepository repository = new MemberMemoryRepository();

    @Override
    public Member findByTarget(String unique) {
        return repository.findByTarget(unique);
    }

    @Override
    public Member findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Set<Member> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Member member) {
        repository.add(member);
    }

    @Override
    public void update(Member member) {

    }

    @Override
    public void delete(Member member) {

    }
}
