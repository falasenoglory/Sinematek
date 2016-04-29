package com.rngstudios.sinematek.ui;

import android.app.Application;
import com.rngstudios.sinematek.BuildConfig;
import timber.log.Timber;

/**
 * Created by jemaystermind on 4/29/2016.
 */
public class SinematekApp extends Application {
  @Override public void onCreate() {
    super.onCreate();
    initTimber();
  }

  void initTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }
}
