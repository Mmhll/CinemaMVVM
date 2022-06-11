package com.mhl.cinemarate.ui.kinopoisk

import androidx.lifecycle.*
import com.mhl.cinemarate.repository.kinopoisk.KinopoiskDataRepository
import com.mhl.cinemarate.repository.kinopoisk.RatingKinopoisk
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class KinopoiskViewModel @Inject constructor(@Named("KinopoiskRepository") private val kinopoiskRepository : KinopoiskDataRepository) : ViewModel() {

    private val _data = MutableLiveData<RatingKinopoisk>()
    val data = _data

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            kinopoiskRepository.getTop().collect {
                _data.value = it
            }
        }
    }


}