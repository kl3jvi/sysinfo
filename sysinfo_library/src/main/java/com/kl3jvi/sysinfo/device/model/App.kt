package com.kl3jvi.sysinfo.device.model

import android.content.Context
import com.kl3jvi.sysinfo.device.DeviceInfo
import org.json.JSONObject

class App(context: Context) {

    data class ApplicationDetails(
        var appVersionName: String?,
        var appVersionCode: Int?,
        var packageName: String?,
        var activityName: String?,
        var appName: String?
    )

    private lateinit var details: ApplicationDetails

    init {
        val deviceInfo = DeviceInfo(context)
        details = ApplicationDetails(
            deviceInfo.versionName,
            deviceInfo.versionCode,
            deviceInfo.packageName,
            deviceInfo.activityName,
            deviceInfo.appName
        )
    }

    fun toJSON(): JSONObject? {
        return try {
            val jsonObject = JSONObject()
            jsonObject.put("appVersionName", details.appVersionName)
            jsonObject.put("appVersionCode", details.appVersionCode)
            jsonObject.put("packageName", details.packageName)
            jsonObject.put("activityName", details.activityName)
            jsonObject.put("appName", details.appName)
            jsonObject
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
