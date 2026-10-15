
import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository<T, ID>
        implements CrudRepository<T, ID> {

    private final Map<ID, T> data = new HashMap<>();

    @Override
    public T save(ID id, T entity) {
        data.put(id, entity);
        return entity;
    }

    @Override
    public T findById(ID id) {
        return data.get(id);
    }

    @Override
    public boolean deleteById(ID id) {
        return data.remove(id) != null;
    }

    public int count() {
        return data.size();
    }
}
