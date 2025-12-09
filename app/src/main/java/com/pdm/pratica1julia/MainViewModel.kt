package com.pdm.pratica1julia

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.model.LatLng
import com.pdm.pratica1julia.api.WeatherService
import com.pdm.pratica1julia.db.fb.FBCity
import com.pdm.pratica1julia.db.fb.FBDatabase
import com.pdm.pratica1julia.db.fb.FBUser
import com.pdm.pratica1julia.db.fb.toFBCity
import com.pdm.pratica1julia.model.City
import com.pdm.pratica1julia.model.User

class MainViewModel (private val db: FBDatabase, private val service : WeatherService) : ViewModel(), FBDatabase.Listener {
    private val _cities = mutableStateListOf<City>()
    val cities
        get() = _cities.toList()
    private val _user = mutableStateOf<User?> (null)
    val user : User?
        get() = _user.value
    init {
        db.setListener(this)
    }

    fun addCity(name: String) {
        service.getLocation(name) { lat, lng ->
            if (lat != null && lng != null) {
                db.add(City(name=name, location=LatLng(lat, lng)).toFBCity())
            }
        }
    }
    fun addCity(location: LatLng) {
        service.getName(location.latitude, location.longitude) { name ->
            if (name != null) {
                db.add(City(name = name, location = location).toFBCity())
            }
        }
    }

    fun remove(city: City) {
        db.remove(city.toFBCity())
    }
    fun add(name: String, location : LatLng? = null) {
        db.add(City(name = name, location = location).toFBCity())
    }
    override fun onUserLoaded(user: FBUser) {
        _user.value = user.toUser()
    }
    override fun onUserSignOut() {
        //TODO("Not yet implemented")
    }
    override fun onCityAdded(city: FBCity) {
        _cities.add(city.toCity())
    }
    override fun onCityUpdated(city: FBCity) {
        //TODO("Not yet implemented")
    }
    override fun onCityRemoved(city: FBCity) {
        _cities.remove(city.toCity())
    }

    }
private fun getCities() = List(20) { i ->
    City(name = "Cidade $i", weather = "Carregando clima...")
}
