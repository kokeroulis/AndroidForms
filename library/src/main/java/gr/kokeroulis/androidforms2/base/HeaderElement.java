package gr.kokeroulis.androidforms2.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface HeaderElement {
    int formId();

    int id();

    @NonNull
    String type();

    @Nullable
    String title();

    @Nullable
    String imageUrl();
}
