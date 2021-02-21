package com.life.ipc.bean;

import android.os.Parcel;
import android.os.Parcelable;

//实现Parcelable序列化接口
public class People implements Parcelable {

    private String mName;
    private String mSex;
    private String mId;

    public People() {

    }

    public String getmName() {
        return mName;
    }

    public String getmSex() {
        return mSex;
    }

    public String getmId() {
        return mId;
    }

    public People(String mName, String mSex, String mId) {
        this.mName = mName;
        this.mSex = mSex;
        this.mId = mId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mSex);
        dest.writeString(mId);
    }

    //实现反序列化
    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People[] newArray(int size) {
            return new People[size];
        }

        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }
    };

    public People(Parcel in) {
        this.mName = in.readString();
        this.mSex = in.readString();
        this.mId = in.readString();
    }

    @Override
    public String toString() {
        return super.toString() + ",People{" +
                "mName='" + mName + '\'' +
                ", mSex='" + mSex + '\'' +
                ", mId='" + mId + '\'' +
                '}';
    }
}
