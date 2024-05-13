package core.princple.spring_core_principle.domain.item.model;

import core.princple.spring_core_principle.domain.core.domain.Domain;
import lombok.*;

@Getter @NoArgsConstructor @AllArgsConstructor @Builder @EqualsAndHashCode
public class Item implements Domain {

    private Long id;
    private String name;
    private Integer amount;
    private Category category;

}
