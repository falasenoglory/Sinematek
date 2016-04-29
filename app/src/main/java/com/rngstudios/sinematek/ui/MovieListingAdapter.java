/*
 * Created by Jeremy Tecson on 4/29/2016.
 *
 * Copyright (c) 2016 Arcanys, Inc.
 */
package com.rngstudios.sinematek.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.rngstudios.sinematek.R;
import com.rngstudios.sinematek.ui.model.MovieItemViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Add class header comment!
 */
public class MovieListingAdapter extends BaseAdapter {

  private List<MovieItemViewModel> items = new ArrayList<>();
  private final Context context;
  private final LayoutInflater inflater;

  public MovieListingAdapter(Context context, List<MovieItemViewModel> items) {
    this.context = context;
    this.items = items;
    this.inflater = LayoutInflater.from(context);
  }

  public void setItems(List<MovieItemViewModel> items) {
    this.items = null;
    this.items = items;
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    if (convertView == null) {
      convertView = inflater.inflate(R.layout.item_movie, parent, false);
      holder = new ViewHolder(convertView);
      convertView.setTag(holder);
    } else {
      holder = ((ViewHolder) convertView.getTag());
    }

    MovieItemViewModel item = getItem(position);
    holder.title.setText(item.title);
    Glide.with(context).load(item.imagePath)
        .placeholder(R.mipmap.ic_launcher)
        .into(holder.thumbnail);

    return convertView;
  }

  @Override public long getItemId(int position) {
    return items.get(position).id;
  }

  @Override public int getCount() {
    return items.size();
  }

  @Override public MovieItemViewModel getItem(int position) {
    return items.get(position);
  }

  class ViewHolder {

    @BindView(R.id.thumbnail) ImageView thumbnail;
    @BindView(R.id.movie_title) TextView title;

    ViewHolder(View view) {
      ButterKnife.bind(this, view);
    }
  }
}
