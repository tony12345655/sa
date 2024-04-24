package useCase.query;

import useCase.port.input.query.QueryInput;

public interface Query<T>{
    T execute(QueryInput queryInput);
}
