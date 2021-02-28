package model

data class Weather (
        val city: City = getDefaultCity(),
        val temperature: Int = 0,
        val feelslike: Int = 0
)

fun getDefaultCity() =
        City(
             "Москва",
             55.755826,
             37.617299900000035
)

