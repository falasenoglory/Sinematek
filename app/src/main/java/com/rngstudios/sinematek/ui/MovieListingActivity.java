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

    items.add(new MovieItemViewModel(1, "Breaking bad 1", "path"));
    items.add(new MovieItemViewModel(1, "Breaking bad 2", "path"));
    items.add(new MovieItemViewModel(1, "Breaking bad 3", "path"));
    items.add(new MovieItemViewModel(1, "Breaking bad 4", "path"));

    adapter = new MovieListingAdapter(this, items);
    listView.setAdapter(adapter);
  }
}
