package com.pdm.pratica1julia.api

data class APILocation (
    var id : String? = null,
    var name : String? = null,
    var region : String? = null,
    var country : String? = null,
    var lat : Double? = null,
    var lon: Double? = null,
    var url : String? = null
)