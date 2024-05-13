package core.princple.spring_core_principle.domain.discount_policy;

import core.princple.spring_core_principle.domain.core.domain.DomainService;
import core.princple.spring_core_principle.domain.discount_policy.model.DiscountPolicy;
import core.princple.spring_core_principle.domain.member.model.Member;

import java.util.Set;

public interface DiscountPolicyService extends DomainService<DiscountPolicy> {

    Set<DiscountPolicy> filterCanApplyGradePolicy(Member orderMember);

    Long apply(Long sum, Set<DiscountPolicy> filter);
}
