package core.princple.spring_core_principle.domain.core.domain;

import java.util.List;
import java.util.Set;

public interface DomainRepository<T extends Domain> {

    /**
     * 단일조회
     * @param unique
     * @return
     */
    T findByTarget(String unique);

    /** 전체조회 */
    Set<T> findAll();

    /** 추가 */
    void add(T t);

    /** 수정 */
    void update(T t);

    /** 삭제 */
    void delete(T t);

}
