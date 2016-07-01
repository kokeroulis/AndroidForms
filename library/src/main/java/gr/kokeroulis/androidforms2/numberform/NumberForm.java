package gr.kokeroulis.androidforms2.numberform;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import gr.kokeroulis.androidforms2.R;
import gr.kokeroulis.androidforms2.base.BaseForm;
import gr.kokeroulis.androidforms2.base.BaseFormLayout;

public class NumberForm extends BaseFormLayout {
    private NumberFormDelegate numberFormDelegate;
    private NumberFormModel numberFormModel;
    private OnValueChangedListener listener;

    public NumberForm(Context context) {
        super(context);
    }

    public NumberForm(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NumberForm(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void bindViews() {
        removeAllViews();
        LayoutInflater.from(getContext())
            .inflate(R.layout.number_form_layout, this, true);

        setInputType(numberFormModel.getInputType());
        setDescription(numberFormModel.description);
        getNumberFormDelegate().getEditView().setText(numberFormModel.value);
        getNumberFormDelegate().getEditView().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                numberFormModel.value = s.toString();
                if (TextUtils.isEmpty(numberFormModel.value)) {
                    return;
                }
                try {
                    Object value = numberFormModel.getValidator().validate(numberFormModel.value);
                    if (listener != null) {
                        listener.onValueChanged(value);
                    }
                } catch (Exception e) {
                    numberFormModel.value = null;
                    getNumberFormDelegate().getEditView().setText("");
                    handleInvalidInput(e);
                }
            }
        });

        if (numberFormModel.throwableError != null) {
            handleInvalidInput(new Throwable(numberFormModel.throwableError.throwableMessage));
        }
    }

    @Override
    public void bindTo(BaseForm baseForm) {

    }

    public void setOnValueChangedListener(OnValueChangedListener listener) {
        this.listener = listener;
    }

    protected void handleInvalidInput(Throwable e) {
        String error = e.getMessage();
        if (e instanceof NumberFormatException) {
            error = "Your input is not a valid number";
        }

        hideKeyboardFrom(this);
        numberFormModel.throwableError = new ErrorHandler();
        numberFormModel.throwableError.throwableMessage = error;
        new AlertDialog.Builder(getContext())
            .setTitle("Invalid Input")
            .setMessage(error)
            .setCancelable(false)
            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    numberFormModel.throwableError = null;
                }
            })
            .show();
    }

    public void bindTo(@NonNull final NumberFormModel numberFormModel) {
        this.numberFormModel = numberFormModel;
        setInputType(numberFormModel.getInputType());
        setDescription(numberFormModel.description);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bindViews();
    }

    protected NumberFormDelegate getNumberFormDelegate() {
        if (numberFormDelegate == null) {
            numberFormDelegate = new NumberFormDelegateImpl(this);
        }

        return numberFormDelegate;
    }

    public void setInputType(int type) {
        if (getNumberFormDelegate().getEditView() != null) {
            getNumberFormDelegate().getEditView().setInputType(numberFormModel.getInputType());
        }
    }

    public void setDescription(@NonNull final String description) {
        if (getNumberFormDelegate().getDescriptionView() != null) {
            getNumberFormDelegate().getDescriptionView().setText(description);
        } else {
            numberFormModel.description = description;
        }
    }

    public static class NumberFormDelegateImpl implements NumberFormDelegate {
        private ViewGroup parentViewGroup;

        public NumberFormDelegateImpl(ViewGroup viewGroup) {
            parentViewGroup = viewGroup;
        }

        @Override
        public TextView getDescriptionView() {
            return (TextView) parentViewGroup.findViewById(R.id.android_forms_number_description);
        }

        @Override
        public EditText getEditView() {
            return (EditText) parentViewGroup.findViewById(R.id.android_forms_number_value);
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            parentViewGroup = null;
        }
    }

    private void hideKeyboardFrom(@NonNull final View view) {
        final Context context = view.getContext();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public interface OnValueChangedListener {
        void onValueChanged(Object value);
    }
}
