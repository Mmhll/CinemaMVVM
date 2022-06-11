package com.mhl.cinemarate.repository.imdb

data class RatingImdb (
    val items: List<ImdbItem>,
    val errorMessage: String
)

data class ImdbItem (
    val id: String,
    val rank: String,
    val title: String,
    val fullTitle: String,
    val year: String,
    val image: String,
    val crew: String,
    val imDBRating: String,
    val imDBRatingCount: String
)