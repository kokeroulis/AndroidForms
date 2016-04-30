package gr.kokeroulis.androidforms.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class BaseFormLayout extends FrameLayout {
    public BaseFormLayout(Context context) {
        super(context);
    }

    public BaseFormLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseFormLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BaseFormLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public abstract void bindTo(BaseForm baseForm);
}
