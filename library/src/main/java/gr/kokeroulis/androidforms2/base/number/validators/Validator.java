package gr.kokeroulis.androidforms2.base.number.validators;

public interface Validator<T> {

    T validate(String value) throws Exception;
}
