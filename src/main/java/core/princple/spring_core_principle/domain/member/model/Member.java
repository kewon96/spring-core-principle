package core.princple.spring_core_principle.domain.member.model;


import core.princple.spring_core_principle.domain.core.domain.Domain;
import core.princple.spring_core_principle.domain.member.enums.MemberGrade;

import java.util.UUID;

/**
 * 회원 Entity
 * 
 * @param id 회원이 입력하는 ID가 아닌 생성할 때 privet 하게 등록되는 ID
 * @param email 회원 Email -> 일반적인 User Id 대체
 * @param password 비밀번호
 * @param Grade 회원 등급
 */
public record Member(
        UUID id,
        String email,
        String password,
        MemberGrade Grade
) implements Domain {

    public Member() {
        this(UUID.randomUUID(), null, null, null);
    }

    public Member(String email, String password, MemberGrade grade) {
        this(UUID.randomUUID(), email, password, grade);
    }
}
