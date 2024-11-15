package ma.youcode.wrm.common;

public interface GenericService<T>  {
    boolean isExist(Long id);
    T findById(Long id);
}
