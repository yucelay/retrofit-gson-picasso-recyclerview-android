package com.yucel.retrofitpicassoandroid.services;

import com.yucel.retrofitpicassoandroid.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("all-users.php")
    Call<List<User>> getAllUsers();

}
