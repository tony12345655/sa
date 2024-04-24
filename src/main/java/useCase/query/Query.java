package useCase.query;

abstract public class Query<T>{
    protected abstract T execute();
}
