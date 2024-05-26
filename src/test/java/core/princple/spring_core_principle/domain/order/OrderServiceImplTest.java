package core.princple.spring_core_principle.domain.order;

import core.princple.spring_core_principle.domain.core.config.AppConfig;
import core.princple.spring_core_principle.domain.discount_policy.DiscountPolicyService;
import core.princple.spring_core_principle.domain.discount_policy.DiscountPolicyServiceImpl;
import core.princple.spring_core_principle.domain.discount_policy.enums.DiscountType;
import core.princple.spring_core_principle.domain.discount_policy.enums.DiscountUnit;
import core.princple.spring_core_principle.domain.discount_policy.model.DiscountPolicy;
import core.princple.spring_core_principle.domain.item.model.Category;
import core.princple.spring_core_principle.domain.item.model.Item;
import core.princple.spring_core_principle.domain.member.MemberService;
import core.princple.spring_core_principle.domain.member.MemberServiceImpl;
import core.princple.spring_core_principle.domain.member.enums.MemberGrade;
import core.princple.spring_core_principle.domain.member.model.Member;
import core.princple.spring_core_principle.domain.order.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

class OrderServiceImplTest {

    private OrderService orderService;
    private MemberService memberService;
    private DiscountPolicyService discountPolicyService;

    @org.junit.jupiter.api.Order(1)
    @BeforeEach
    void set() {
        AppConfig appConfig = new AppConfig();

        orderService = appConfig.orderService();
        memberService = appConfig.memberService();
        discountPolicyService = appConfig.discountPolicyService();
    }

    @org.junit.jupiter.api.Order(2)
    @BeforeEach
    void 기본회원_만들기() {
        Member member = new Member("test@test.io", "1234", MemberGrade.VIP);
        memberService.add(member);
    }

    @org.junit.jupiter.api.Order(2)
    @BeforeEach
    void 기본_할인정책_추가() {
        // 고정금액 할인형
        discountPolicyService.add(
                DiscountPolicy.builder()
                        .type(DiscountType.MEMBER_GRADE)
                        .unit(DiscountUnit.STATIC)
                        .value(1000)
                        .memberGrade(MemberGrade.VIP)
                        .build()
        );

        // 퍼센테이지 할인형
        discountPolicyService.add(
                DiscountPolicy.builder()
                        .type(DiscountType.MEMBER_GRADE)
                        .unit(DiscountUnit.PERCENTAGE)
                        .value(10)
                        .memberGrade(MemberGrade.VIP)
                        .build()
        );
    }

    @Test
    void createOrder() {

        Member member = memberService.findByEmail("test@test.io");

        // When
        Order order = orderService.createOrder(member.id(), getItems());
        Set<Order> byMember = orderService.findByMember(member);

        Assertions.assertTrue(byMember.contains(order));
    }

    private Set<Item> getItems() {
        Category category = new Category(1000L, "분류1");
        return Set.of(
                new Item(1L, "상품1", 300000, category),
                new Item(2L, "상품2", 200000, category),
                new Item(3L, "상품3", 100000, category),
                new Item(4L, "상품4", 400000, category),
                new Item(5L, "상품5", 500000, category)
        );
    }
}