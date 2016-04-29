package com.rngstudios.sinematek.data.api.model;

import com.google.common.base.MoreObjects;
import com.google.gson.annotations.SerializedName;

public class Movie {

  public final long id;
  public final String title;
  public final String overview;
  @SerializedName("poster_path") public final String posterPath;

  public Movie(long id, String title, String overview, String posterPath) {
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
