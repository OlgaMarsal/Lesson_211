package viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val liveDataToObserver: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl()
) :
    ViewModel() {

    fun getLiveData() = liveDataToObserver

    fun getWeatherFromLocalSourceRus() = getDataFromLocalSource(isRussian = true)

    fun getWeatherFromRemoteSourceWorld() = getDataFromLocalSource(isRussian = false)

    fun getWeatherFromRemoteSource() = getDataFromLocalSource(isRussian = true)

    private fun getDataFromLocalSource(isRussian: Boolean) {
        liveDataToObserver.value = AppState.Loading
        Thread {
            sleep(1000)

            val data =
                if (isRussian)
                    repositoryImpl.getWeatherFromLocalStorageRus()
                else
                    repositoryImpl.getWeatherFromLocalStorageWorld()

            liveDataToObserver.postValue(
                    AppState.Success(data)
            )
        }.start()
    }
}