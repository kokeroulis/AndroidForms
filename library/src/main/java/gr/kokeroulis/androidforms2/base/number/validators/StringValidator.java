package gr.kokeroulis.androidforms2.base.number.validators;

import android.text.TextUtils;

public class StringValidator implements Validator<String> {

    public StringValidator() {
    }

    @Override
    public String validate(String value) throws Exception {
        if (TextUtils.isEmpty(value)) {
            throw new RuntimeException("Your must fill your value");
        } else {
            return value;
        }
    }
}
