package com.example.up_mob;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitAPI {

    @POST("/user")
    Call<User> createPost(@Body User user);


}

