package core.princple.spring_core_principle.domain.discount_policy;

import core.princple.spring_core_principle.domain.discount_policy.enums.DiscountType;
import core.princple.spring_core_principle.domain.discount_policy.enums.DiscountUnit;
import core.princple.spring_core_principle.domain.discount_policy.model.DiscountPolicy;
import core.princple.spring_core_principle.domain.discount_policy.repository.DiscountPolicyMemoryRepository;
import core.princple.spring_core_principle.domain.discount_policy.repository.DiscountPolicyRepository;
import core.princple.spring_core_principle.domain.member.model.Member;

import java.util.Set;
import java.util.stream.Collectors;

public class DiscountPolicyServiceImpl implements DiscountPolicyService {

    private final DiscountPolicyRepository repository;

    public DiscountPolicyServiceImpl(DiscountPolicyRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiscountPolicy findByTarget(String unique) {
        return null;
    }

    @Override
    public Set<DiscountPolicy> filterCanApplyGradePolicy(Member orderMember) {
        Set<DiscountPolicy> memberGradePolicy = findMemberGradePolicy();

        return memberGradePolicy.stream().filter(x ->
                x.getMemberGrade().equals(orderMember.grade())
        ).collect(Collectors.toSet());
    }

    /**
     * 회원에 대한 할인정책 반영해서 주문금액 계산
     *
     * 단, 할인정책 반영순서는 무작위로 적용(규칙성정하기 무리...)
     *
     * @param sum 총 금액
     * @param filter 반영할 할인정책
     *
     * @return 총 주문금액
     */
    @Override
    public Long apply(Long sum, Set<DiscountPolicy> filter) {
        return filter.stream().mapToLong(x -> calcByUnit(sum, x)).sum();
    }

    @Override
    public Set<DiscountPolicy> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(DiscountPolicy discountPolicy) {
        repository.add(discountPolicy);
    }

    @Override
    public void update(DiscountPolicy discountPolicy) {

    }

    @Override
    public void delete(DiscountPolicy discountPolicy) {

    }


    private Set<DiscountPolicy> findMemberGradePolicy() {
        return repository.findByType(DiscountType.MEMBER_GRADE);
    }

    private Long calcByUnit(Long sum, DiscountPolicy policy) {

        if(policy.getUnit().equals(DiscountUnit.STATIC)) {
            return sum - policy.getValue();
        }

        return sum * ((100 - policy.getValue()) / 100);
    }
}
