package gr.kokeroulis.androidforms2.demo.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import gr.kokeroulis.androidforms2.base.FormElement;

public class EnumFormElement implements FormElement {

    public final int id;
    public final String value;

    public EnumFormElement(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public EnumFormElement(int id) {
        this(id, null);
    }

    public EnumFormElement withValue(String value) {
        return new EnumFormElement(id, value);
    }

    @Override
    public int id() {
        return id;
    }

    @NonNull
    @Override
    public String key() {
        return "some random key";
    }

    @NonNull
    @Override
    public String type() {
        return "enum";
    }

    @Nullable
    @Override
    public String value() {
        return value;
    }
}
