package ma.youcode.wrm.common;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


public abstract class GenericServiceImpl<T> implements GenericService<T>  {

    @PersistenceContext
    private EntityManager manager;
    private final Class<T> entityClass;

    public GenericServiceImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public boolean isExist(Long id) {
        return manager.find(entityClass,id) != null;
    }

    @Override
    public T findById(Long id) {
        return manager.find(entityClass, id);
    }
}
