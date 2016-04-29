/*
 * Created by Jeremy Tecson on 4/29/2016.
 *
 * Copyright (c) 2016 Arcanys, Inc.
 */
package com.rngstudios.sinematek.ui.model;

import com.google.common.base.MoreObjects;

/**
 * TODO: Add class header comment!
 */
public class MovieItemViewModel {
  public final long id;
  public final String title;
  public final String imagePath;

  public MovieItemViewModel(long id, String title, String imagePath) {
    this.title = title;
    this.imagePath = imagePath;
    this.id = id;
  }

  @Override public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("title", title)
        .add("imagePath", imagePath)
        .toString();
  }
}
