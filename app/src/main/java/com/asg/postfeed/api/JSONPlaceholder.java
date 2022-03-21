package com.asg.postfeed.api;

import com.asg.postfeed.model.Comment;
import com.asg.postfeed.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholder {

    @GET("posts")
    Call<List<Post>> getPost();

    @GET("comments")
    Call<List<Comment>> getComment();

}
