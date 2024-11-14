package ma.youcode.wrm.common;


public interface BaseMapper<T , R , E, C , U>{
    R toResponseDTO(T entity);
    E toEmbeddedDTO(T entity);
    T fromCreateDTO(C dto);
    T fromUpdateDTO(U dto);
}
