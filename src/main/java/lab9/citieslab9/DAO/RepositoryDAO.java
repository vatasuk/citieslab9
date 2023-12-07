package lab9.citieslab9.DAO;

import java.util.List;

public interface RepositoryDAO<T> {
    public Long insert(T o);

    public void update(T o);

    public void delete(Long Id);
    // Поиск сущности по Id
    public T findById(Long Id);

    public List<T> findAll();
}