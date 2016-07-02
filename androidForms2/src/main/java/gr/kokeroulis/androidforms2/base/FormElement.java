package gr.kokeroulis.androidforms2.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface FormElement {
    int id();

    @NonNull
    String key();

    @NonNull
    String type();

    @Nullable
    String value();
}
