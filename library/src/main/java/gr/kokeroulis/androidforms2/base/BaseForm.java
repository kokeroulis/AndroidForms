package gr.kokeroulis.androidforms2.base;

import android.os.Parcelable;

public abstract class BaseForm implements FormType, Parcelable {
    public String key;
    public String id;
}
