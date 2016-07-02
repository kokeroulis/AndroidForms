package gr.kokeroulis.androidforms2.base.number;


public interface OnNumberValueChangedListener<T, V extends NumberFormElement<T>> {

    void onValueChanged(T value, V element);

    void onError(Throwable error);
}
