package core.princple.spring_core_principle.domain.core.config;

import core.princple.spring_core_principle.domain.discount_policy.DiscountPolicyService;
import core.princple.spring_core_principle.domain.discount_policy.DiscountPolicyServiceImpl;
import core.princple.spring_core_principle.domain.discount_policy.repository.DiscountPolicyMemoryRepository;
import core.princple.spring_core_principle.domain.member.MemberService;
import core.princple.spring_core_principle.domain.member.MemberServiceImpl;
import core.princple.spring_core_principle.domain.member.repository.MemberMemoryRepository;
import core.princple.spring_core_principle.domain.order.OrderService;
import core.princple.spring_core_principle.domain.order.OrderServiceImpl;
import core.princple.spring_core_principle.domain.order.repository.OrderMemoryRepository;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberMemoryRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                orderRepository(),
                memberService(),
                discountPolicyService()
        );
    }

    public DiscountPolicyService discountPolicyService() {
        return new DiscountPolicyServiceImpl(discountPolicyMemoryRepository());
    }

    public OrderMemoryRepository orderRepository() {
        return new OrderMemoryRepository();
    }

    public DiscountPolicyMemoryRepository discountPolicyMemoryRepository() {
        return new DiscountPolicyMemoryRepository();
    }

    public MemberMemoryRepository memberMemoryRepository() {
        return new MemberMemoryRepository();
    }

}
