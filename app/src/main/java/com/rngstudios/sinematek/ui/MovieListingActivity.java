package com.rngstudios.sinematek.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import com.google.common.collect.Lists;
import com.rngstudios.sinematek.R;
import com.rngstudios.sinematek.data.api.TheMovieDbApi;
import com.rngstudios.sinematek.data.api.model.BaseResponse;
import com.rngstudios.sinematek.data.api.model.Movie;
import com.rngstudios.sinematek.ui.mapper.MovieMapper;
import com.rngstudios.sinematek.ui.model.MovieDetailViewModel;
import com.rngstudios.sinematek.ui.model.MovieItemViewModel;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class MovieListingActivity extends AppCompatActivity {

  @BindView(R.id.list) ListView listView;

  MovieListingAdapter adapter;
  List<Movie> movies;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie_listing);
    ButterKnife.bind(this);

    // TODO Jemay: Re-implement this mess! Ewwwwww!
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

    OkHttpClient httpClient = new OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build();

    Retrofit retrofit = new Retrofit.Builder()
        .client(httpClient)
        .baseUrl(TheMovieDbApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    TheMovieDbApi service = retrofit.create(TheMovieDbApi.class);
    service.getPopularMovies().enqueue(new Callback<BaseResponse<Movie>>() {
      @Override public void onResponse(Call<BaseResponse<Movie>> call,
          Response<BaseResponse<Movie>> response) {
        if (response.isSuccessful()) {
          final BaseResponse<Movie> body = response.body();
          MovieListingActivity.this.movies = null;
          final List<Movie> results = MovieListingActivity.this.movies = body.results;
          List<MovieItemViewModel> movieViewModels = Lists.newArrayList();
          for (Movie movie : results) {
            movieViewModels.add(MovieMapper.toMovieItem(movie));
          }

          adapter.setItems(movieViewModels);
          adapter.notifyDataSetChanged();
        }
      }

      @Override public void onFailure(Call<BaseResponse<Movie>> call, Throwable t) {
        // TODO Jemay: Handle failure response
        Timber.e("errorMessage=%s", t.getMessage());
        t.printStackTrace();
      }
  });

    adapter = new MovieListingAdapter(this, new ArrayList<MovieItemViewModel>());
    listView.setAdapter(adapter);
  }

  @OnItemClick(R.id.list) void onItemClick(int position) {
    MovieDetailViewModel movieDetail = MovieMapper.toMovieDetail(this.movies.get(position));
    startActivity(MovieDetailActivity.newIntent(this, movieDetail));
  }
}
