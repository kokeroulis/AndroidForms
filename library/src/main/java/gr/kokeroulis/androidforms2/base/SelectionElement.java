package gr.kokeroulis.androidforms2.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface SelectionElement {
    int formId();

    int id();

    @Nullable
    String title();

    @NonNull
    String key();

    @NonNull
    String type();

    boolean isSelected();
}
