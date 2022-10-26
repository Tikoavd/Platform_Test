package com.picsartacademy.platform;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceholder {
    @GET("posts")
    Call<List<Post>> getPost();

    @GET("users")
    Call<List<User>> getUsers();

    @GET("comments")
    Call<List<Comment>> getComments(@Query("postId") int postId);
}
