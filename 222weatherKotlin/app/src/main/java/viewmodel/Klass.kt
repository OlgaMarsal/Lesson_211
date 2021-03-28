package viewmodel

import android.os.Handler
import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import model.City

fun main () {

    val city = City("City", 12.1212, 12.1212)

    printCity(city)
    CityPrinter(city)
}

fun printCity(city: City) {

}

class CityPrinter(private val city: City)