package com.mhl.cinemarate.ui.imdb

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhl.cinemarate.repository.imdb.ImdbDataRepository
import com.mhl.cinemarate.repository.imdb.RatingImdb
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ImdbViewModel @Inject constructor(
    @Named("ImdbRepository") private val imdbDataRepository: ImdbDataRepository
    ) : ViewModel() {

    private val _remoteData = MutableLiveData<RatingImdb>()
    val remoteData = _remoteData

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            imdbDataRepository.getTopImdb().collect {
                _remoteData.value = it
            }
        }
    }
}