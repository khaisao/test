package jp.slapp.android

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle

class AppApplication : Application() {

    companion object {
        var context: Context? = null
        fun getAppContext(): Context? {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()

        AppsFlyerUtil.createAppsFlyer(this)
    }

    private class AdjustLifecycleCallbacks : ActivityLifecycleCallbacks {
        override fun onActivityResumed(activity: Activity) {}

        override fun onActivityPaused(activity: Activity) {}

        override fun onActivityStarted(activity: Activity) {}

        override fun onActivityDestroyed(activity: Activity) {}

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

        override fun onActivityStopped(activity: Activity) {}

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
    }

}
