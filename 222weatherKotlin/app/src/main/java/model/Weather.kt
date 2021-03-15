package model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField

@Parcelize
data class Weather (
        val city: City = getDefaultCity(),
        val temperature: Int = 0,
        val feelslike: Int = 0
) : Parcelable

fun getDefaultCity() =
        City(
             "Москва",
             55.755826,
             37.617299900000035
)

fun getWorldCities(): List<Weather> {
    return listOf(
        Weather(City("Лондон", 51.5085300, -0.1257400), 1, 2),
    )
}

fun getRussianCities(): List<Weather> {
    return listOf(
            Weather(City("Москва", 55.755826, 37.617299900000035), 1, 2),
    )

}

