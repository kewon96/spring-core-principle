package core.princple.spring_core_principle.domain.member.repository;

import core.princple.spring_core_principle.domain.core.domain.DomainRepository;
import core.princple.spring_core_principle.domain.member.model.Member;

public sealed interface MemberRepository extends DomainRepository<Member> permits MemberMemoryRepository, MemberDatabaseRepository {
    Member findByEmail(String email);
}
