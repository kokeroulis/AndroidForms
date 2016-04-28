package gr.kokeroulis.androidforms.base;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public interface FormType {
    ViewGroup viewGroup(@NonNull final Context context);
}
