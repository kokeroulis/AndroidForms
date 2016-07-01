package gr.kokeroulis.androidforms2.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public abstract class BaseFormLayout extends LinearLayout {
    public BaseFormLayout(Context context) {
        super(context);
        setOrientation(VERTICAL);
    }

    public BaseFormLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
    }

    public BaseFormLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
    }

    public abstract void bindTo(BaseForm baseForm);
}
