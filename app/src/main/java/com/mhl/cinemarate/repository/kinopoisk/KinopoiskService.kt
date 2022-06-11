package com.mhl.cinemarate.repository.kinopoisk

import retrofit2.http.GET
import retrofit2.http.Header

interface KinopoiskService {
    @GET("top?type=TOP_250_BEST_FILMS")
    suspend fun getTopKinopoisk(@Header("X-API-KEY") key : String) : RatingKinopoisk

}