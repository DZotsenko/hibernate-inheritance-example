package core.basesyntax.model.ma;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Coach extends Person {
    public enum Track {
        JAVA, FE, UI, QA
    }

    @Id
    private Long id;
    private int experience;
    @Enumerated(EnumType.STRING)
    private Track track;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
