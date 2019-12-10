package com.example.mediabrowsertestapp

import android.annotation.SuppressLint
import android.media.browse.MediaBrowser
import android.os.Bundle
import android.service.media.MediaBrowserService
import leakcanary.AppWatcher

@SuppressLint("NewApi")
class MediaPlaybackService : MediaBrowserService() {

    override fun onLoadChildren(
        parentId: String,
        result: Result<MutableList<MediaBrowser.MediaItem>>
    ) {
        result.sendResult(mutableListOf())
    }

    override fun onGetRoot(
        clientPackageName: String, clientUid: Int,
        rootHints: Bundle?
    ): BrowserRoot? {
        return BrowserRoot("MediaPlaybackService", null)
    }


    override fun onDestroy() {
        super.onDestroy()
        AppWatcher.objectWatcher.watch(this)
    }
}