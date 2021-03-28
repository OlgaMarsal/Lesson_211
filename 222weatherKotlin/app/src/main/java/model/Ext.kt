package model

import android.os.Bundle
import android.os.Handler
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.versionedparcelable.ParcelField
import model.City
import view.DetailsFragment
import view.MainFragment
import kotlin.reflect.KClass

fun main() {
    val str: String = "Valery"

    val FirstNameLetter: String = str.getFirstLetter()

    print("Extension result = ")
    print(firstNameLetter)
    println()

    val fragment: Fragment = MainFragment::class.createFragment(Bundle())
    print(fragment::class.simpleName)

    "123".let {
        String
        it.substring(0, 1)
    }
    "123".apply {
        String
        this.substring(0, 1)
    }
}

fun String.getFirstLetter(): String {
    return this.substring(0,1)
}

fun KClass<*>.createFragment(bundle: Bundle): Fragment =
        when (this) {
            MainFragment::class -> MainFragment.newInstance()
            DetailsFragment::class -> DetailsFragment.newInstance(bundle)
            else -> throw IllegalAccessException("Unknown fragment class")
        }

fun FragmentManager.addToBackStack(kClass: KClass<*>, bundle: Bundle) =
        beginTransaction()
                .add(R.id.container, kClass.createFragment(bundle))
                .addToBackStack("")
                .commit()