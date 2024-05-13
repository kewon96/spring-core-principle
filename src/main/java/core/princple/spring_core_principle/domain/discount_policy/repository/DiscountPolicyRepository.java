package core.princple.spring_core_principle.domain.discount_policy.repository;

import core.princple.spring_core_principle.domain.core.domain.DomainRepository;
import core.princple.spring_core_principle.domain.discount_policy.enums.DiscountType;
import core.princple.spring_core_principle.domain.discount_policy.model.DiscountPolicy;

import java.util.Set;

public interface DiscountPolicyRepository extends DomainRepository<DiscountPolicy> {

    Set<DiscountPolicy> findByType(DiscountType discountType);

}
