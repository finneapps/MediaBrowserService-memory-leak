# MediaBrowserService-memory-leak
Sample app with MediaBrowserService that contains a memory leak
Created MediaPlaybackService and MainActivity. 
I have added leak canary and added AppWatcher.objectWatcher.watch(this) in the onDestroy method. 
When opening and exiting the app, leak canary finds a leak:

6153 bytes retained
    ┬
    ├─ android.service.media.MediaBrowserService$ServiceBinder
    │    Leaking: UNKNOWN
    │    GC Root: Global variable in native code
    │    ↓ MediaBrowserService$ServiceBinder.this$0
    │                                        ~~~~~~
    ├─ androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26
    │    Leaking: UNKNOWN
    │    MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26 does not wrap an activity context
    │    ↓ MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26.mBase
    │                                                                                      ~~~~~
    ╰→ com.example.mediabrowsertestapp.MediaPlaybackService
    ​     Leaking: YES (ObjectWatcher was watching this)
    ​     MediaPlaybackService does not wrap an activity context
    ​     key = 11f40383-1498-4743-9f20-208cbd2839a1
    ​     watchDurationMillis = 5191
    ​     retainedDurationMillis = 183

Please include this in bug reports and Stack Overflow questions.

    Build.VERSION.SDK_INT: 28
    Build.MANUFACTURER: HMD Global
    LeakCanary version: 2.0
    App process name: com.example.mediabrowsertestapp
    Analysis duration: 8967 ms
    Heap dump file path: /data/user/0/com.example.mediabrowsertestapp/files/leakcanary/2019-12-10_10-21-47_693.hprof
    Heap dump timestamp: 1575969720525
