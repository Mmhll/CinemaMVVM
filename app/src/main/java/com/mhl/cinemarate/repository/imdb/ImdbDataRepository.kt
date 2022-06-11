package com.mhl.cinemarate.repository.imdb

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ImdbDataRepository @Inject constructor(private val imdbService: ImdbService, private val key : String) {

    suspend fun getTopImdb() : Flow<RatingImdb> {
        return flow{
            try {
                val data = imdbService.getTopImdb(key)
                emit(data)
            } catch (t : Throwable){
                when (t){
                    is IOException -> Log.d("EXCEPTION", t.message.toString())
                    is HttpException -> {
                        val code = t.code()
                        Log.d("EXCEPTION", code.toString() + t.message)
                    }
                }
            }

        }.flowOn(Dispatchers.IO)
    }


    suspend fun getBodyImdb() : Flow<ResponseBody> {
        return flow{
            val data = imdbService.getResponseBody(key)
            emit(data)
        }.flowOn(Dispatchers.IO)
    }


    suspend fun getFilmImdb(id : String) : Flow<ImdbItem> {
        return flow {
            val data = imdbService.getFilmImdb(key, id)
            emit(data)
        }.flowOn(Dispatchers.IO)
    }
}
