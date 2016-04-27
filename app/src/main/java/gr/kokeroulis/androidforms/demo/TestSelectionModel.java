package gr.kokeroulis.demo;

import android.os.Parcel;
import android.os.Parcelable;

import gr.kokeroulis.demo.selectionform.SelectionModel;

public class TestSelectionModel implements SelectionModel, Parcelable {

    public String title;

    public TestSelectionModel(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return null;
    }

    @Override
    public int textColor() {
        return 0;
    }

    @Override
    public int backgroundColor() {
        return 0;
    }

    protected TestSelectionModel(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TestSelectionModel> CREATOR = new Creator<TestSelectionModel>() {
        @Override
        public TestSelectionModel createFromParcel(Parcel in) {
            return new TestSelectionModel(in);
        }

        @Override
        public TestSelectionModel[] newArray(int size) {
            return new TestSelectionModel[size];
        }
    };
}
