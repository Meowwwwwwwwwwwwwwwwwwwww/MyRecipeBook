package com.example.myrecipebook

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



private val retrofit =Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/").addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService = retrofit.create(ApiServices::class.java)// here a interface apiservice get combined with above url


interface ApiServices{


        @GET("categories.php")// this get merged in above retrofit url and we achieve a response
 suspend fun getCategories():/* return type*/ CategoryResponse
}