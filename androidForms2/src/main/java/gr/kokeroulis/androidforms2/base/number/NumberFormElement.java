package gr.kokeroulis.androidforms2.base.number;

import gr.kokeroulis.androidforms2.base.FormElement;
import gr.kokeroulis.androidforms2.base.number.validators.Validator;

public interface NumberFormElement<T> extends FormElement {

    Validator<T> getValidator();

    int getFormType();

    String title();
}
