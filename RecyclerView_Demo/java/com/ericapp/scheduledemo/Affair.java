package com.ericapp.scheduledemo;

import java.util.Date;
import java.util.UUID;

public class Affair {
    private UUID mId;
    private String mTitle;
    private Date mDeadline;
    private boolean mSolved;

    public Affair() {
        mId = UUID.randomUUID();
        mDeadline = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDeadline() {
        return mDeadline;
    }

    public void setDeadline(Date deadline) {
        mDeadline = deadline;
    }

    public boolean isSolved(boolean isChecked) {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                ", mDate=" + mDeadline +
                ", mSolved=" + mSolved +
                '}';
    }
}
