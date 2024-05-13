package core.princple.spring_core_principle.domain.discount_policy.model;

import core.princple.spring_core_principle.domain.core.domain.Domain;
import core.princple.spring_core_principle.domain.discount_policy.enums.DiscountType;
import core.princple.spring_core_principle.domain.discount_policy.enums.DiscountUnit;
import core.princple.spring_core_principle.domain.item.model.Category;
import core.princple.spring_core_principle.domain.member.enums.MemberGrade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 할인 정책
 *
 */
@Getter @NoArgsConstructor @AllArgsConstructor
@Builder
public class DiscountPolicy implements Domain {

    private Integer id;
    private DiscountType type;
    private DiscountUnit unit;
    private Integer value;

    private MemberGrade memberGrade;
    private Category category;
}
