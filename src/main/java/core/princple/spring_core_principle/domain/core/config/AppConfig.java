package core.princple.spring_core_principle.domain.core.config;

import core.princple.spring_core_principle.domain.discount_policy.DiscountPolicyService;
import core.princple.spring_core_principle.domain.discount_policy.DiscountPolicyServiceImpl;
import core.princple.spring_core_principle.domain.discount_policy.repository.DiscountPolicyMemoryRepository;
import core.princple.spring_core_principle.domain.member.MemberService;
import core.princple.spring_core_principle.domain.member.MemberServiceImpl;
import core.princple.spring_core_principle.domain.member.repository.MemberDatabaseRepository;
import core.princple.spring_core_principle.domain.member.repository.MemberMemoryRepository;
import core.princple.spring_core_principle.domain.member.repository.MemberRepository;
import core.princple.spring_core_principle.domain.order.OrderService;
import core.princple.spring_core_principle.domain.order.OrderServiceImpl;
import core.princple.spring_core_principle.domain.order.repository.OrderMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberMemoryRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                orderRepository(),
                memberService(),
                discountPolicyService()
        );
    }

    @Bean
    public DiscountPolicyService discountPolicyService() {
        return new DiscountPolicyServiceImpl(discountPolicyMemoryRepository());
    }

    @Bean
    public OrderMemoryRepository orderRepository() {
        return new OrderMemoryRepository();
    }

    @Bean
    public DiscountPolicyMemoryRepository discountPolicyMemoryRepository() {
        return new DiscountPolicyMemoryRepository();
    }

    @Bean
    public FooClass fooClass() {
        return new FooClass();
    }

    @Bean
    public F2Class f2Class() {
        return new F2Class();
    }

    @Bean
    public Foo3Class foo3Class() {
        return new Foo3Class();
    }

    @Bean
    public MemberMemoryRepository memberMemoryRepository() {
        return new MemberMemoryRepository();
    }

//    @Bean("memberMemoryRepository")
//    public MemberRepository memberDatabaseRepository() {
//        return new MemberDatabaseRepository();
//    }

}
