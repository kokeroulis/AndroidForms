package gr.kokeroulis.androidforms.numberform;


import android.view.inputmethod.EditorInfo;

public class IntegerFormModel extends NumberFormModel {

    @Override
    public int getInputType() {
        return EditorInfo.TYPE_CLASS_PHONE;
    }

    @Override
    public Validator getValidator() {
        return new IntegerValidator();
    }

    public static class IntegerValidator implements Validator<Integer> {

        @Override
        public Integer validate(Object value) throws Exception {
            return Integer.parseInt(value.toString());
        }
    }
}
