package com.kl3jvi.deviceinformation

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kl3jvi.sysinfo.ads.Ad
import com.kl3jvi.sysinfo.ads.AdInfo
import com.kl3jvi.sysinfo.location.LocationInfo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textV = findViewById<TextView>(R.id.tv)
        val ad = AdInfo(this)

        val location = LocationInfo(this)
        textV.text = location.location.postalCode

    }
}