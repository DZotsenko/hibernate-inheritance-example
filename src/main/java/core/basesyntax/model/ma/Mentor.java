package core.basesyntax.model.ma;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Mentor extends Person {
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
