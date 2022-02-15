package dream.model;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;


public class Post {
    private int id;
    private String name;
    private String description;
    private final Timestamp created;

    public Post(int id, String name) {
        this.id = id;
        this.name = name;
        this.description = "";
        this.created = Timestamp.from(Instant.now());
    }

    public Post(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = Timestamp.from(Instant.now());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated() {
        return created;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id && name.equals(post.name) && Objects.equals(description, post.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, created);
    }
}