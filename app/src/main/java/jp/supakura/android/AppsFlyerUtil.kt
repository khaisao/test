package jp.supakura.android

import android.content.Context
import android.util.Log
import com.appsflyer.AFInAppEventParameterName
import com.appsflyer.AFInAppEventType
import com.appsflyer.AppsFlyerLib
import com.appsflyer.attribution.AppsFlyerRequestListener
import kotlin.collections.HashMap

class AppsFlyerUtil {

    companion object {
        private const val AF_DEV_KEY = "nJT5tjqhr6pb2SwYZPhYaS";
        private const val TAG = "asgagagwawgagw"

        private lateinit var appsFlyer: AppsFlyerLib
        private lateinit var context: Context

        fun createAppsFlyer(context: Context) {
            this.context = context
            appsFlyer = AppsFlyerLib.getInstance()
            appsFlyer.setAppId("jp.supakura.android")
            appsFlyer.init(AF_DEV_KEY, null, context)
            appsFlyer.start(context)
        }

        fun setDebugLog() {
            appsFlyer.setDebugLog(true)
        }

        fun logEvent(
            eventName: String,
            eventValues: HashMap<String, Any>
        ) {

            appsFlyer.logEvent(context, eventName, eventValues, object : AppsFlyerRequestListener {
                override fun onSuccess() {
                    Log.d(TAG, "onSuccess: ")
                }

                override fun onError(errorCode: Int, errorDesc: String) {
                    Log.d(
                        TAG, " Event failed to be sent:\n" +
                                "Error code: " + errorCode + "\n"
                                + "Error description: " + errorDesc
                    )
                }
            })
        }

        fun handleEventRegistration(memberCode: String) {
            appsFlyer.setCustomerUserId(memberCode)
            val eventValues = HashMap<String, Any>()
            eventValues.put(AFInAppEventParameterName.CONTENT, memberCode)
            logEvent(AFInAppEventType.COMPLETE_REGISTRATION, eventValues)
        }
    }
}