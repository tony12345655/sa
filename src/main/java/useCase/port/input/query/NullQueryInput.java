package useCase.port.input.query;

public class NullQueryInput implements QueryInput{
    @Override
    public String getQuery(){
        return null;
    }

}
