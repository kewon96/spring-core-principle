package core.princple.spring_core_principle;

import core.princple.spring_core_principle.domain.core.config.AppConfig;
import core.princple.spring_core_principle.domain.member.MemberService;
import core.princple.spring_core_principle.domain.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringCorePrincipleApplicationTests {

    private AnnotationConfigApplicationContext context;

    @BeforeEach
    void set() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }


    @Test
    void 빈_등록된거_확인해보기() {
        // Given
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        AnnotationConfigApplicationContext appConfig = new AnnotationConfigApplicationContext(AppConfig.class);

        String[] contextBeanNames = context.getBeanDefinitionNames();
        String[] configBeanNames = appConfig.getBeanDefinitionNames();

//        configBeanNames.

        // When


        // Then
        assertTrue(contextBeanNames.length != 0);
        assertTrue(configBeanNames.length != 0);

    }

    @Test
    void 빈_이름으로_조회() {
        MemberService memberService = context.getBean("memberService", MemberService.class);

        assertTrue(memberService.getClass().isAssignableFrom(MemberServiceImpl.class));
    }

    @Test
    void 타입으로_조회() {
        MemberService memberService = context.getBean(MemberService.class);

        assertTrue(memberService.getClass().isAssignableFrom(MemberServiceImpl.class));
    }

    @Test
    void 구체타입으로_조회() {
        // 구현에 의존해야해서 보통 이렇게 쓰진않지만?
        // 쓸땐 써도됨
        MemberService memberService = context.getBean(MemberServiceImpl.class);

        assertTrue(memberService.getClass().isAssignableFrom(MemberServiceImpl.class));
    }

    @Test
    void 빈_이름으로_조회안됨() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> {
            MemberService memberService = context.getBean("memberServic", MemberServiceImpl.class);
            assertTrue(memberService.getClass().isAssignableFrom(MemberServiceImpl.class));
        });
    }

}
