package gr.kokeroulis.androidforms2.demo.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import gr.kokeroulis.androidforms2.base.HeaderElement;

public class EnumHeaderElement implements HeaderElement {
    public final int id;
    public final int formId;
    public final String title;
    public final String imageUrl;


    public EnumHeaderElement(int id, int formId, String title, String imageUrl) {
        this.id = id;
        this.formId = formId;
        this.title = title;
        this.imageUrl = imageUrl;
    }


    @Override
    public int formId() {
        return formId;
    }

    @Override
    public int id() {
        return id;
    }

    @NonNull
    @Override
    public String type() {
        return "HEADER_TYPE";
    }

    @Nullable
    @Override
    public String title() {
        return title;
    }

    @Nullable
    @Override
    public String imageUrl() {
        return imageUrl;
    }
}
