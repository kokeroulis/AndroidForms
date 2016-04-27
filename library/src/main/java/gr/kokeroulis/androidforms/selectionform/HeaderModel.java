package gr.kokeroulis.androidforms.selectionform;

import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;

public class HeaderModel {

    public @ColorRes int backgroundColor;

    public @ColorRes int textColor;

    public @NonNull String title;

    public HeaderModel(int backgroundColor, int textColor, @NonNull String title) {
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.title = title;
    }
}
