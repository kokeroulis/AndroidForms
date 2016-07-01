package gr.kokeroulis.androidforms2.selectionform;

import android.os.Parcelable;

public interface SelectionModel extends Parcelable {

    String title();

    String key();

    int textColor();

    int backgroundColor();
}
