package com.example.up_mob;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @POST("user/login")
    Call<User> createUser(@Body SendUser sendUser);
}
