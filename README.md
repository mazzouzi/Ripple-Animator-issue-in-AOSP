# Ripple-Animator-issue-in-AOSP

Repro steps:

* Start an Android 12 or Android 13 DP 2 emulator
* Install the app

```
./gradlew app:installDebug
```

* Start the app, click on **Add new button** then **Delete/leak me**
* Wait 5-10 seconds.

LeakCanary triggers and reports the ripple leak.
