package gr.kokeroulis.androidforms.numberform;

public interface Validator<T> {

    T validate(Object value) throws Exception;
}
