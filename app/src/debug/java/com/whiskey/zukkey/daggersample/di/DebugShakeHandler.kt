package com.whiskey.zukkey.daggersample.di

import android.content.Context
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.squareup.seismic.ShakeDetector


class DebugShakeHandler(
    private val activity: AppCompatActivity
): ShakeHandler, ShakeDetector.Listener {

  override fun onCreate() {
    val sensorManager = activity.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val shakeDetector = ShakeDetector(this)
    shakeDetector.start(sensorManager)
  }

  override fun hearShake() {
    Toast.makeText(activity, "Shaked!", Toast.LENGTH_SHORT).show()
  }

  override fun onDestroy() {
    // do nothing
  }
}
