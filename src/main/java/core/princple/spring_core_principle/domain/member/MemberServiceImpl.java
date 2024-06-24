package core.princple.spring_core_principle.domain.member;

import core.princple.spring_core_principle.domain.member.model.Member;
import core.princple.spring_core_principle.domain.member.repository.MemberRepository;
import core.princple.spring_core_principle.domain.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository repository;
//    private final OrderService orderService;

//    public MemberServiceImpl(MemberRepository repository) {
//        this.repository = repository;
//    }

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
