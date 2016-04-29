package com.rngstudios.sinematek.data.api.model;

import com.google.common.base.MoreObjects;
import java.util.List;

public class BaseResponse<T> {
  public final List<T> results;

  public BaseResponse(List<T> results) {
    this.results = results;
  }

  @Override public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("results", results)
        .toString();
  }
}
