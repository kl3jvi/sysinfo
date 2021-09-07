package com.kl3jvi.sysinfo.ads

import android.content.Context

class AdInfo(private val context: Context) {

    val ad: Ad
        @Throws(Exception::class)
        get() {
            val adInfo = AdvertisingIdClient.getAdvertisingIdInfo(context)
            val advertisingId = adInfo.id
            val adDoNotTrack = adInfo.isLimitAdTrackingEnabled
            val ad = Ad(
                advertisingId,
                adDoNotTrack
            )
            return ad
        }


    fun getAndroidAdId(callback: AdIdCallback) {
        Thread {
            try {
                val ad = ad
                callback.onResponse(context, ad)
            } catch (e: Exception) {
                e.printStackTrace()
                e.message?.let { message ->
                    callback.onError(context, message)
                }
            }
        }.start()
    }

    interface AdIdCallback {
        fun onResponse(context: Context, ad: Ad)
        fun onError(context: Context, message: String)
    }
}


