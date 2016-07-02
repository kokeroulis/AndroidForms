package gr.kokeroulis.androidforms2.demo.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.inputmethod.EditorInfo;

import gr.kokeroulis.androidforms2.base.number.FloatFormElement;
import gr.kokeroulis.androidforms2.base.number.validators.FloatValidator;
import gr.kokeroulis.androidforms2.base.number.validators.Validator;

public class FloatFormModel implements FloatFormElement {
    public final int id;
    public final String value;
    public final float minValue;
    public final float maxValue;
    public final String title;

    public FloatFormModel(int id, String value, String title, float minValue, float maxValue) {
        this.id = id;
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.title = title;
    }

    public FloatFormModel(int id, String title, int minValue, int maxValue) {
        this(id, null, title, minValue, maxValue);
    }

    public FloatFormModel withValue(String value) {
        return new FloatFormModel(id, value, title, minValue, maxValue);
    }

    @Override
    public Validator<Float> getValidator() {
        return new FloatValidator(minValue, maxValue);
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
        return "float type";
    }

    @Nullable
    @Override
    public String value() {
        return value;
    }

    @Override
    public float getMinValue() {
        return minValue;
    }

    @Override
    public float getMaxValue() {
        return maxValue;
    }

}