package com.pdm.pratica1julia.db.fb

import com.google.android.gms.maps.model.LatLng
import com.pdm.pratica1julia.model.City

class FBCity {
    var name : String? = null
    var lat : Double? = null
    var lng : Double? = null
    fun toCity(): City {
        val latlng = if (lat!=null&&lng!=null) LatLng(lat!!, lng!!) else null
        return City(name = name!!, location = latlng)
    }
}
fun City.toFBCity() : FBCity {
    val fbCity = FBCity()
    fbCity.name = this.name
    // Se location for null, lat e lng devem ser salvos como null no FBCity
    fbCity.lat = this.location?.latitude
    fbCity.lng = this.location?.longitude
    return fbCity
}
