package core.princple.spring_core_principle.domain.order.repository;

import core.princple.spring_core_principle.domain.member.model.Member;
import core.princple.spring_core_principle.domain.order.model.Order;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class OrderMemoryRepository implements OrderRepository {

    private final ConcurrentMap<Long, Order> store = new ConcurrentHashMap<>();

    @Override
    public Order findByTarget(String unique) {
        return store.get(Long.valueOf(unique));
    }

    @Override
    public Set<Order> findAll() {
        return new HashSet<>(store.values());
    }

    @Override
    public Set<Order> findByMember(Member member) {
        return store.values().stream().filter(x -> x.getMemberId().equals(member.id())).collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public void add(Order order) {
        int size = store.values().size();

        store.put((long) size, order);
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(Order order) {

    }
}
