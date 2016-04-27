package gr.kokeroulis.androidforms.selectionform;

import android.os.Parcelable;

public interface SelectionModel extends Parcelable {

    String title();

    int textColor();

    int backgroundColor();
}
