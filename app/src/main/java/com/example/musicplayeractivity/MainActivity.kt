package com.example.musicplayeractivity

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log



class MainActivity : AppCompatActivity() {

    // Declare a MediaPlayer instance as a property of the Activity
    private var mediaPlayer: MediaPlayer? = null
    private val TAG = "ccsl"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the MediaPlayer instance and start playing a default audio file
        mediaPlayer = MediaPlayer.create(this, R.raw.song)
        mediaPlayer?.start()
        Log.i(TAG, "onCreate")
        Log.i(TAG, "Audio file detected")
    }


    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onCreate")
        Log.i(TAG, "Audio file begins to playing")
        if (mediaPlayer?.isPlaying == false) {
            mediaPlayer?.start()
        }
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
        Log.i(TAG, "Pause playing")
        mediaPlayer?.pause()
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
        Log.i(TAG, "Stopped playing")
        // Do not release the MediaPlayer here
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release the MediaPlayer when the activity is destroyed
        mediaPlayer?.release()
        mediaPlayer = null
        Log.i(TAG, "onDestroy")
        Log.i(TAG, "Close media player")
    }
}