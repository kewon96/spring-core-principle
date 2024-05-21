package core.princple.spring_core_principle.domain.member;

import core.princple.spring_core_principle.domain.core.domain.DomainService;
import core.princple.spring_core_principle.domain.member.model.Member;

public interface MemberService extends DomainService<Member> {
    Member findByEmail(String email);
}
