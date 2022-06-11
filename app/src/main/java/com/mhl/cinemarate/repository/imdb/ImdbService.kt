package com.mhl.cinemarate.repository.imdb

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface ImdbService {
    @GET("Top250Movies/{apiKey}")
    suspend fun getTopImdb(@Path("apiKey") key : String) : RatingImdb

    @GET("Top250Movies/{apiKey}")
    suspend fun getResponseBody(@Path("apiKey") key : String) : ResponseBody

    @GET("Search/{apiKey}/{filmId}")
    suspend fun getFilmImdb(@Path("apiKey") key : String, @Path("filmId") id : String) : ImdbItem
}