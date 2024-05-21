package core.princple.spring_core_principle.domain.discount_policy.repository;

import core.princple.spring_core_principle.domain.discount_policy.enums.DiscountType;
import core.princple.spring_core_principle.domain.discount_policy.model.DiscountPolicy;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class DiscountPolicyMemoryRepository implements DiscountPolicyRepository {

    private final ConcurrentMap<Integer, DiscountPolicy> store = new ConcurrentHashMap<>();

    @Override
    public DiscountPolicy findByTarget(String unique) {
        return null;
    }

    @Override
    public Set<DiscountPolicy> findByType(DiscountType discountType) {
        return store.values().stream().filter(x -> x.getType().equals(discountType)).collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<DiscountPolicy> findAll() {
        return Set.copyOf(store.values());
    }

    @Override
    public void add(DiscountPolicy discountPolicy) {
        int size = store.values().size();

        discountPolicy.createId(size);

        store.put(discountPolicy.getId(), discountPolicy);
    }

    @Override
    public void update(DiscountPolicy discountPolicy) {

    }

    @Override
    public void delete(DiscountPolicy discountPolicy) {

    }
}
