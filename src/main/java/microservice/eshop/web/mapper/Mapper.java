package microservice.eshop.web.mapper;

public interface Mapper<T, S> {
    T map(S s);

    S mapToDto(T t);
}
