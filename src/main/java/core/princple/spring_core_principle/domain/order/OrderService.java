package core.princple.spring_core_principle.domain.order;

import core.princple.spring_core_principle.domain.core.domain.DomainService;
import core.princple.spring_core_principle.domain.item.model.Item;
import core.princple.spring_core_principle.domain.member.model.Member;
import core.princple.spring_core_principle.domain.order.model.Order;

import java.util.Set;
import java.util.UUID;

public interface OrderService extends DomainService<Order> {

    Set<Order> findByMember(Member member);

    Order createOrder(UUID memberId, Set<Item> items);


}
