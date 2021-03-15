package ru.geekbrains.a221

import android.view.View
import android.view.WindowId

open class MyKotlin {

    fun getGreetings(name: String, surname: String) : String? = null
}

interface MyInterface {

}

class MyKotlin2(private val name: String, private var surname: String) : MyKotlin(), MyInterface {

    lateinit var userId: String

    fun foo() {
        val list = listOf("1", "2", "3")

        list.forEach {
            print(it)
        }

        for (i in 100 downTo 0 step 2){
            print(list[i])
        }

        while (true) {

        }

        val array : Array<IntArray> = arrayOfNulls<IntArray>()
    }
}

fun main() {
    val klass = MyKotlin2("name", " surname")
}

object Constants {

    const val url = "String"
    var userId = "String"

    fun getUrlAndUserId(): String {
        return url + userId
    }
}

data class MyClass (val id: String)