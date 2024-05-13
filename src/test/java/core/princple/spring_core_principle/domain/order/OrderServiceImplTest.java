package core.princple.spring_core_principle.domain.order;

import core.princple.spring_core_principle.domain.item.model.Category;
import core.princple.spring_core_principle.domain.item.model.Item;
import core.princple.spring_core_principle.domain.member.MemberService;
import core.princple.spring_core_principle.domain.member.MemberServiceImpl;
import core.princple.spring_core_principle.domain.member.enums.MemberGrade;
import core.princple.spring_core_principle.domain.member.model.Member;
import core.princple.spring_core_principle.domain.order.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class OrderServiceImplTest {

    private static final OrderService orderService = new OrderServiceImpl();
    private final MemberService memberService = new MemberServiceImpl();

    @Test
    void createOrder() {
        // Give
        Member member = new Member("test@test.io", "1234", MemberGrade.VIP);
        memberService.add(member);

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