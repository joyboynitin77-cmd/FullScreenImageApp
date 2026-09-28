package com.example.fullscreenimage

import android.app.Activity
import android.graphics.Color
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.VideoView
import java.io.File

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.setBackgroundColor(Color.BLACK)
        hideSystemBars()

        // Put your video at app/src/main/assets/opening_video.mp4
        val videoFile = File(cacheDir, "opening_video.mp4")
        if (!videoFile.exists()) {
            assets.open("opening_video.mp4").use { input ->
                videoFile.outputStream().use { output -> input.copyTo(output) }
            }
        }

        val video = VideoView(this).apply {
            setBackgroundColor(Color.BLACK)
            setVideoURI(Uri.fromFile(videoFile))
            contentDescription = "Opening video"
            setOnPreparedListener { player: MediaPlayer ->
                player.isLooping = true
                player.setVolume(1.0f, 1.0f)
                start()
            }
        }

        setContentView(video)
    }

    private fun hideSystemBars() {
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.let { controller ->
                controller.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                controller.systemBarsBehavior =
                    WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            )
        }
    }
}
