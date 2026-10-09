package hospital.model;

import java.time.LocalDateTime;

public abstract class BaseEntity {

    private final int id;
    private final LocalDateTime createdAt;

    protected BaseEntity(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }

        this.id = id;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public abstract String getEntityType();
}
