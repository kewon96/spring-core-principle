package core.princple.spring_core_principle.domain.order;

import core.princple.spring_core_principle.domain.discount_policy.DiscountPolicyService;
import core.princple.spring_core_principle.domain.discount_policy.model.DiscountPolicy;
import core.princple.spring_core_principle.domain.item.model.Item;
import core.princple.spring_core_principle.domain.member.MemberService;
import core.princple.spring_core_principle.domain.member.model.Member;
import core.princple.spring_core_principle.domain.order.model.Order;
import core.princple.spring_core_principle.domain.order.repository.OrderRepository;

import java.util.Set;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    private final DiscountPolicyService discountPolicyService;
    private final MemberService memberService;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository, MemberService memberService, DiscountPolicyService discountPolicyService) {
        this.discountPolicyService = discountPolicyService;
        this.orderRepository = orderRepository;
        this.memberService = memberService;
    }

    @Override
    public Order findByTarget(String unique) {
        return orderRepository.findByTarget(unique);
    }

    @Override
    public Set<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Set<Order> findByMember(Member member) {
        return orderRepository.findByMember(member);
    }

    /**
     * 주문기능
     *
     * <ol>
     *     <li>주문한 회원정보 가져오기</li>
     *     <li>주문금액 합산</li>
     *     <li>할인정책 가져오기</li>
     *     <li>할인정책 반영하기</li>
     * </ol>
     *
     * @param memberId 주문한 회원
     * @param items 주문한 상품
     */
    @Override
    public Order createOrder(UUID memberId, Set<Item> items) {

        Member orderMember = memberService.findByTarget(memberId.toString());
        long sum = items.stream().mapToLong(Item::getAmount).sum();
        Set<DiscountPolicy> policySet = discountPolicyService.filterCanApplyGradePolicy(orderMember);
        Long orderAmount = discountPolicyService.apply(sum, policySet);

        Order order = Order.builder()
                .id((long) findAll().size())
                .memberId(memberId)
                .orderItems(items)
                .discountPolicies(policySet)
                .orderAmount(orderAmount)
                .build();

        add(order);

        return order;

    }

    @Override
    public void add(Order order) {
        orderRepository.add(order);
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(Order order) {

    }
}
