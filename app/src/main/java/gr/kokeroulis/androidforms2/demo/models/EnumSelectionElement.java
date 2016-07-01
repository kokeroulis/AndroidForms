package gr.kokeroulis.androidforms2.demo.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import gr.kokeroulis.androidforms2.base.SelectionElement;

public class EnumSelectionElement implements SelectionElement {
    public final int formId;
    public final int id;
    public final String title;
    public final boolean isSelected;

    public EnumSelectionElement(int formId, int id, String title, boolean isSelected) {
        this.formId = formId;
        this.id = id;
        this.title = title;
        this.isSelected = isSelected;
    }

    public EnumSelectionElement withChecked(boolean checked) {
        return new EnumSelectionElement(formId, id, title, checked);
    }

    @Override
    public int formId() {
        return formId;
    }

    @Override
    public int id() {
        return id;
    }

    @Nullable
    @Override
    public String title() {
        return title;
    }

    @NonNull
    @Override
    public String key() {
        return "some randrom element key";
    }

    @NonNull
    @Override
    public String type() {
        return "enum_entry";
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }
}
