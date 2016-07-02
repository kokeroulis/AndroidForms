package gr.kokeroulis.androidforms2.demo.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.inputmethod.EditorInfo;

import gr.kokeroulis.androidforms2.base.number.IntegerFormElement;
import gr.kokeroulis.androidforms2.base.number.validators.IntegerValidator;
import gr.kokeroulis.androidforms2.base.number.validators.Validator;

/**
 * Created by kokeroulis on 02/07/16.
 */

public class IntegerFormModel implements IntegerFormElement {
    public final int id;
    public final String value;
    public final int minValue;
    public final int maxValue;
    public final String title;

    public IntegerFormModel(int id, String value, String title, int minValue, int maxValue) {
        this.id = id;
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.title = title;
    }

    public IntegerFormModel(int id, String title, int minValue, int maxValue) {
        this(id, null, title, minValue, maxValue);
    }

    public IntegerFormModel withValue(String value) {
        return new IntegerFormModel(id, value, title, minValue, maxValue);
    }

    @Override
    public Validator<Integer> getValidator() {
        return new IntegerValidator(minValue, maxValue);
    }

    @Override
    public int getFormType() {
        return EditorInfo.TYPE_CLASS_PHONE;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public int id() {
        return id;
    }

    @NonNull
    @Override
    public String key() {
        return "Some random key";
    }

    @NonNull
    @Override
    public String type() {
        return "integer type";
    }

    @Nullable
    @Override
    public String value() {
        return value;
    }

    @Override
    public int getMinValue() {
        return minValue;
    }

    @Override
    public int getMaxValue() {
        return maxValue;
    }
}
