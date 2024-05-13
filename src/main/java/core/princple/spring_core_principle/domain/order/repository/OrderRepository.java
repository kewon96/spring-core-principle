package core.princple.spring_core_principle.domain.order.repository;

import core.princple.spring_core_principle.domain.core.domain.DomainRepository;
import core.princple.spring_core_principle.domain.member.model.Member;
import core.princple.spring_core_principle.domain.order.model.Order;

import java.util.Set;

public interface OrderRepository extends DomainRepository<Order> {
    Set<Order> findByMember(Member member);

}
