package com.mhl.cinemarate.repository.kinopoisk

data class RatingKinopoisk (
    val pagesCount: Long,
    val films: List<KinopoiskFilm>
)

data class KinopoiskFilm (
    val filmID: Long,
    val nameRu: String,
    val nameEn: String? = null,
    val year: String,
    val filmLength: String,
    val countries: List<Country>,
    val genres: List<Genre>,
    val rating: String,
    val ratingVoteCount: Long,
    val posterURL: String,
    val posterURLPreview: String,
    val ratingChange: Any? = null
)

data class Country (
    val country: String
)

data class Genre (
    val genre: String
)
