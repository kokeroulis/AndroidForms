package gr.kokeroulis.androidforms2.numberform;

public interface Validator<T> {

    T validate(String value) throws Exception;
}
