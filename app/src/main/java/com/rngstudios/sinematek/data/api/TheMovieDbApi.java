package com.rngstudios.sinematek.data.api;

import com.rngstudios.sinematek.data.api.model.BaseResponse;
import com.rngstudios.sinematek.data.api.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMovieDbApi {

  String BASE_URL = "https://api.themoviedb.org/3/";
  String API_KEY = "64c1d35c6ac9dbe2ea7e52ff3921c7bf";
  String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/original";

  @GET("movie/popular?api_key=" + API_KEY)
  Call<BaseResponse<Movie>> getPopularMovies();

  @GET
  Call<BaseResponse<Movie>> getPopularMovies(@Query("api_key") String apiKey);
}
