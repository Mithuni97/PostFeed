package com.asg.postfeed.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable {

    private String userId, id, title, body;

    protected Post(Parcel in) {
        userId = in.readString();
        id = in.readString();
        title = in.readString();
        body = in.readString();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userId);
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(body);
    }
}
