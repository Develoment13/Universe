package com.development.hybrid.universe.ui.apod.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class APODModel {

    private String date;
    private String explanation;
    private String hdUrl;
    @SerializedName("Url")
    private String lowResUrl;
    private String title;
    private String copyright;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getHdUrl() {
        return hdUrl;
    }

    public void setHdUrl(String hdUrl) {
        this.hdUrl = hdUrl;
    }

    public String getLowResUrl() {
        return lowResUrl;
    }

    public void setLowResUrl(String lowResUrl) {
        this.lowResUrl = lowResUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @NonNull
    @Override
    public String toString() {
        return "APODModel{" +
                "date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", hdUrl='" + hdUrl + '\'' +
                ", lowResUrl='" + lowResUrl + '\'' +
                ", title='" + title + '\'' +
                ", copyright='" + copyright + '\'' +
                '}';
    }
}
