package com.authapp.network

import com.authapp.data.LoginApiResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthAppApi {
    @FormUrlEncoded
    @POST("/login")
    fun LOGIN(@Field("email") email: String, @Field("password") password: String): Call<LoginApiResponse>
}

