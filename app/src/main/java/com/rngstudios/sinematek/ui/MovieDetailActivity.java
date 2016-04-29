package com.rngstudios.sinematek.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.rngstudios.sinematek.R;
import com.rngstudios.sinematek.ui.model.MovieDetailViewModel;

public class MovieDetailActivity extends AppCompatActivity {

  @BindView(R.id.banner) ImageView poster;
  @BindView(R.id.title) TextView title;
  @BindView(R.id.overview) TextView overview;

  public static Intent newIntent(Context context, MovieDetailViewModel viewModel) {
    Intent intent = new Intent(context, MovieDetailActivity.class);
    intent.putExtra("id", viewModel.id);
    intent.putExtra("title", viewModel.title);
    intent.putExtra("overview", viewModel.overview);
    intent.putExtra("posterPath", viewModel.posterPath);
    return intent;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie_detail);
    ButterKnife.bind(this);

    final Bundle extras = getIntent().getExtras();
    long movieId = extras.getLong("id"); // Useless for now
    String title = extras.getString("title");
    String overview = extras.getString("overview");
    String posterPath = extras.getString("posterPath");

    // Update views
    this.title.setText(title);
    this.overview.setText(overview);
    Glide.with(this).load(posterPath).placeholder(R.mipmap.ic_launcher).into(poster);
  }
}
