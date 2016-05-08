package gr.kokeroulis.androidforms.numberform;

public interface Validator<T> {

    T validate(String value) throws Exception;
}
