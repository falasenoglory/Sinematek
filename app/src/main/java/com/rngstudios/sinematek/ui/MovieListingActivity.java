package com.rngstudios.sinematek.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.BaseAdapter;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rngstudios.sinematek.R;
import com.rngstudios.sinematek.ui.model.MovieItemViewModel;
import java.util.ArrayList;
import java.util.List;

public class MovieListingActivity extends AppCompatActivity {

  @BindView(R.id.list) ListView listView;

  BaseAdapter adapter;
  List<MovieItemViewModel> items = new ArrayList<>();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    String baseImagePath = "http://image.tmdb.org/t/p/original";
    items.add(new MovieItemViewModel(1, "Fight Club",
        baseImagePath + "/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg"));
    items.add(new MovieItemViewModel(1, "Batman v Superman: Dawn of Justice",
        baseImagePath + "/6bCplVkhowCjTHXWv49UjRPn0eK.jpg"));
    items.add(new MovieItemViewModel(1, "Deadpool",
        baseImagePath + "/k1QUCjNAkfRpWfm1dVJGUmVHzGv.jpg"));
    items.add(new MovieItemViewModel(1, "Star War: The Force Awakens",
        baseImagePath + "/weUSwMdQIa3NaXVzwUoIIcAi85d.jpg"));

    adapter = new MovieListingAdapter(this, items);
    listView.setAdapter(adapter);
  }
}
