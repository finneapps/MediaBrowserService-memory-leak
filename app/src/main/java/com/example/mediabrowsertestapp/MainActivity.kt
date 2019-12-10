package com.example.mediabrowsertestapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ComponentName
import android.media.browse.MediaBrowser
import android.os.Bundle

@SuppressLint("NewApi")
class MainActivity : Activity() {
    private lateinit var mediaBrowser: MediaBrowser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaBrowser = MediaBrowser(
            this,
            ComponentName(this, MediaPlaybackService::class.java),
            connectionCallbacks,
            null
        )
    }

    override fun onStart() {
        super.onStart()
        mediaBrowser.connect()
    }

    override fun onStop() {
        super.onStop()
        mediaBrowser.disconnect()
    }

    private val connectionCallbacks = object : MediaBrowser.ConnectionCallback() {
        override fun onConnected() {
        }

        override fun onConnectionSuspended() {

        }

        override fun onConnectionFailed() {

        }
    }
}
