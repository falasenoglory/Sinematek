package com.rngstudios.sinematek;

import android.app.Application;
import timber.log.Timber;

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
