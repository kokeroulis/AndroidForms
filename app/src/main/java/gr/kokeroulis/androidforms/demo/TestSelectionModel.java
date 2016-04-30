package gr.kokeroulis.androidforms.demo;

import android.os.Parcel;

import gr.kokeroulis.androidforms.selectionform.SelectionModel;


public class TestSelectionModel implements SelectionModel {

    public String title;

    public TestSelectionModel(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestSelectionModel)) return false;

        TestSelectionModel that = (TestSelectionModel) o;

        return title != null ? title.equals(that.title) : that.title == null;

    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}
