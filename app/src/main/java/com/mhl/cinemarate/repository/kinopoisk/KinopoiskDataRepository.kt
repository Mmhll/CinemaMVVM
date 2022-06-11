package com.mhl.cinemarate.repository.kinopoisk

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class KinopoiskDataRepository @Inject constructor(
    private val kinopoiskService: KinopoiskService,
    private val key: String
) {
    suspend fun getTop() : Flow<RatingKinopoisk>{
        return flow {
            val data = kinopoiskService.getTopKinopoisk(key)
            emit(data)
        }.flowOn(Dispatchers.IO)
    }
}