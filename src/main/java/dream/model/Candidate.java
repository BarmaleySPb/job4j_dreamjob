package dream.model;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;


public class Candidate {
    private int id;
    private String name;
    private int cityId;
    private final Timestamp created;

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
        this.created = Timestamp.from(Instant.now());
    }

    public Candidate(int id, String name, int cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
        this.created = Timestamp.from(Instant.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public Timestamp getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return id == candidate.id && cityId == candidate.cityId && name.equals(candidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cityId, created);
    }
}
