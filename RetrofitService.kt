package com.example.myapplication

import retrofit2.Call
import retrofit2.http.*

interface  RetrofitService {
    @GET("json/students/")
    fun getStudentsList() : Call<ArrayList<personn>>

    @POST("json/students/")
    fun createStudent(
        @Body params : HashMap<String, Any>
    ) : Call<personn>


    @POST("json/students/")
    fun createStudentEasy(
        @Body person : personn
    ) : Call<personn>

    @POST("user/signup/")
    @FormUrlEncoded
    fun register(
        @Field("username")username : String,
        @Field("password1")password1 : String,
        @Field("password2")password2 : String
    ) : Call<User>

    @POST("user/login/")
    @FormUrlEncoded
    fun login(
        @Field("username") username : String,
        @Field("password") password : String
    ) : Call<User>

    @GET("/instagram/post/lis/all/")
    fun getAllPosts() : Call<ArrayList<Post>>




}