package com.kl3jvi.sysinfo.location

import java.io.Serializable

class DeviceLocation : Serializable {
    var latitude: Double? = 0.0
    var longitude: Double? = 0.0
    var addressLine1: String? = ""
    var city: String? = ""
    var state: String? = ""
    var countryCode: String? = ""
    var postalCode: String? = ""
}