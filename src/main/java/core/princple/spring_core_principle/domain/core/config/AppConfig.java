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
        return new MemberServiceImpl(new MemberMemoryRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new OrderMemoryRepository(),
                memberService(),
                discountPolicyService()
        );
    }

    public DiscountPolicyService discountPolicyService() {
        return new DiscountPolicyServiceImpl(new DiscountPolicyMemoryRepository());
    }

}
