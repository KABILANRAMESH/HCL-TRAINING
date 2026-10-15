
public interface CrudRepository<T, ID> {
    T save(ID id, T entity);

    T findById(ID id);

    boolean deleteById(ID id);
}
