package com.kl3jvi.sysinfo.userapps


import org.json.JSONObject

import java.io.Serializable

class UserApps : Serializable {

    var appName: String? = null
    var packageName: String? = null
    var versionName: String? = null
    var versionCode: Int = 0

    fun toJSON(): JSONObject? {
        val jsonObject = JSONObject()
        return try {
            jsonObject.put("appName", appName)
            jsonObject.put("packageName", packageName)
            jsonObject.put("versionName", versionName)
            jsonObject.put("versionCode", versionCode)
            jsonObject
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }

    }
}