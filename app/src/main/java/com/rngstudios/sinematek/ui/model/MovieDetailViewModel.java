package com.rngstudios.sinematek.ui.model;

import com.google.common.base.MoreObjects;

public class MovieDetailViewModel {
  public final long id;
  public final String title;
  public final String overview;
  public final String posterPath;

  public MovieDetailViewModel(long id, String title, String overview, String posterPath) {
    this.id = id;
    this.title = title;
    this.overview = overview;
    this.posterPath = posterPath;
  }

  @Override public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("title", title)
        .add("overview", overview)
        .add("posterPath", posterPath)
        .toString();
  }
}
