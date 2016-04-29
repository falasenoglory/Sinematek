package com.rngstudios.sinematek.ui.mapper;

import android.support.annotation.NonNull;
import com.rngstudios.sinematek.data.api.TheMovieDbApi;
import com.rngstudios.sinematek.data.api.model.Movie;
import com.rngstudios.sinematek.ui.model.MovieDetailViewModel;
import com.rngstudios.sinematek.ui.model.MovieItemViewModel;

public final class MovieMapper {

  @NonNull public static MovieItemViewModel toMovieItem(@NonNull Movie movie) {
    long id = movie.id;
    String title = movie.title;
    String imagePath = TheMovieDbApi.BASE_IMAGE_URL + movie.posterPath;
    return new MovieItemViewModel(id, title, imagePath);
  }

  @NonNull public static MovieDetailViewModel toMovieDetail(@NonNull Movie movie) {
    long id = movie.id;
    String title = movie.title;
    String overview = movie.overview;
    String imagePath = TheMovieDbApi.BASE_IMAGE_URL + movie.posterPath;
    return new MovieDetailViewModel(id, title, overview, imagePath);
  }

  private MovieMapper() {
    throw new AssertionError("No instances");
  }
}
