package gr.kokeroulis.androidforms.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class FormLayout extends FrameLayout {
    public FormLayout(Context context) {
        super(context);
    }

    public FormLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FormLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Nullable
    public BaseFormLayout getBaseFormLayout(){
        for (int i =0; i < getChildCount(); i++) {
            View v = getChildAt(i);
            if (v instanceof BaseFormLayout) {
                return (BaseFormLayout) v;
            }
        }

        return null;
    }

    public void addBaseForm(@NonNull final BaseFormLayout form) {
        removeAllViews();
        addView(form);
    }
}
