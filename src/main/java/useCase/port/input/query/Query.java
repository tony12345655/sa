package useCase.port.input.query;

import useCase.port.input.query.QueryInput;

public interface Query<T, Q>{
    Q execute(T t);
}
