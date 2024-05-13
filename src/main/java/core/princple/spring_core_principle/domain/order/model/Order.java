package core.princple.spring_core_principle.domain.order.model;

import core.princple.spring_core_principle.domain.core.domain.Domain;
import core.princple.spring_core_principle.domain.discount_policy.model.DiscountPolicy;
import core.princple.spring_core_principle.domain.item.model.Item;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter @NoArgsConstructor @AllArgsConstructor @Builder @EqualsAndHashCode
public class Order implements Domain {

    private Long id;
    private UUID memberId;
    private Set<Item> orderItems;
    private Set<DiscountPolicy> discountPolicies;
    private Long orderAmount;

}
