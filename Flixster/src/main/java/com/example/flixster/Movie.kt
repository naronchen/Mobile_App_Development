package com.example.flixster

import org.json.JSONArray

data class Movie (
    val movieId: Int,
    val posterPath: String,
    val title: String,
    val overview: String,
    ){
    val posterImageURL = "https://image.tmdb.org/t/p/w342/$posterPath";
    companion object{ //call method without having instance
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                        Movie(
                            movieJson.getInt("id"),
                            movieJson.getString("poster_path"),
                            movieJson.getString("title"),
                            movieJson.getString("overview")

                        )
                )
            }
            return movies
    }
}}