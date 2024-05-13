package core.princple.spring_core_principle.domain.discount_policy.enums;

/**
 * 할인정책에 의해 적용되는 할인의 단위
 */
public enum DiscountUnit {
    
    /**
     * 고정값 할인
     * 
     * <p>Ex) 1000원 할인</p>
     */
    STATIC("STATIC"),

    /**
     * 퍼센테이지 할인
     * 
     * <p>Ex) 5% 할인</p>
     */
    PERCENTAGE("PERCENTAGE");

    DiscountUnit(String unit) {}
    
    public String toString() {
        return this.name();
    }
}
