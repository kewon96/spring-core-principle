package core.princple.spring_core_principle.domain.member;

import core.princple.spring_core_principle.domain.member.enums.MemberGrade;
import core.princple.spring_core_principle.domain.member.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberServiceImplTest {

    private final MemberServiceImpl memberService = new MemberServiceImpl();

    @Test
    public void add_and_findAll_vi() {
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 5).forEach(i -> {
//                log.info("thread {}", i);

                executorService.submit(() -> {

                    LinkedHashSet<Member> members = IntStream.range(0, 3000000).mapToObj(x -> {
//                        log.info("thread {} - member {}", i, x);
                        StringBuilder s = new StringBuilder();
                        s.append("thread ").append(i).append(" - member ").append(x);
                        log.info(s.toString());

                        String randomEmail = RandomStringUtils.random(8);
                        String randomPassword = RandomStringUtils.random(16);

                        return new Member(randomEmail + "@gmail.com", randomPassword, MemberGrade.BASIC);
                    }).collect(Collectors.toCollection(LinkedHashSet::new));


//                    members.forEach(memberService::add);
                });
            });
        }
    }

    @Test
    public void add_and_findAll_thread() {
        try (ExecutorService executorService = Executors.newFixedThreadPool(5)) {
            IntStream.range(0, 5).forEach(i -> {
//                log.info("thread {}", i);

                executorService.submit(() -> {

                    LinkedHashSet<Member> members = IntStream.range(0, 3000000).mapToObj(x -> {
//                        log.info("thread {} - member {}", i, x);
                        StringBuilder s = new StringBuilder();
                        s.append("thread ").append(i).append(" - member ").append(x);
                        log.info(s.toString());

                        String randomEmail = RandomStringUtils.random(8);
                        String randomPassword = RandomStringUtils.random(16);

                        return new Member(randomEmail + "@gmail.com", randomPassword, MemberGrade.BASIC);
                    }).collect(Collectors.toCollection(LinkedHashSet::new));


//                    members.forEach(memberService::add);
                });
            });
        }

//        try (ExecutorService executorService = Executors.newFixedThreadPool(30)) {
//            AtomicInteger i = new AtomicInteger();
//
//            executorService.submit(() -> {
//                log.info("thread {}", i.getAndAdd(1));
//                List<Member> members = getMembers();
//
//                members.forEach(memberService::add);
//            });
//        }
    }

    private List<Member> getMembers() {
        List<Member> members = new LinkedList<>();

        for (int i = 0; i < 3000000; i++) {
            String randomEmail = RandomStringUtils.random(8);
            String randomPassword = RandomStringUtils.random(16);

            members.add(new Member(randomEmail + "@gmail.com", randomPassword, MemberGrade.BASIC));
        }

        return members;


    }

}