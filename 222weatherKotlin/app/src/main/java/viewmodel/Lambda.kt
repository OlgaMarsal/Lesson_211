package viewmodel

import android.os.Handler
import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import model.City

fun main() {
    val handler = Handler()

    val lambda: (String, Int, City) -> String = { name, id, city ->


        name + id
    }
    Worker("1", lambda)

    Worker("2") { name, id, city ->

        id.toString()
    }

    Worker(
            "3",
            { name, id, city ->


                name+id
            }
    )
}

fun jobFunc(a1: String, a2: Int, a3: City): String {
    return "1234"
}


fun workerFunc(job: (String, Int, City) -> String) {
    job.invoke("String", 1, City("Name", 12.1212, 12.1212))

    job("String", 1, City("Name", 12.1212, 12.1212))
}

class Worker(private val job: (String, Int, City) -> String) {

    fun doWork() {
        job.invoke("String", 1, City("Name", 12.1212, 12.1212))

        job("String", 1, City("Name", 12.1212, 12.1212))
    }
}

class StringHolder(val string: String)