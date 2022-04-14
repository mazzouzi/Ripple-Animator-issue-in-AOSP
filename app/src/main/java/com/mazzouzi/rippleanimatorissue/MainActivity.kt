package com.mazzouzi.rippleanimatorissue

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import leakcanary.AppWatcher

class MainActivity : Activity() {

  var buttonIndex = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)


    findViewById<View>(R.id.add_button).setOnClickListener {
      addSelfDeletingRippleButton()
    }
  }

  private fun addSelfDeletingRippleButton() {
    buttonIndex++
    val container = findViewById<LinearLayout>(R.id.container)
    container.addView(Button(this).apply {
      text = "Delete/leak me ($buttonIndex)"
      setOnClickListener { button ->
        container.removeView(button)
        AppWatcher.objectWatcher.expectWeaklyReachable(button, "Button $buttonIndex removed")
      }
    })
  }
}