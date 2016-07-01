package gr.kokeroulis.androidforms2.base;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public interface FormType {
    ViewGroup viewGroup(@NonNull final Context context);
}
