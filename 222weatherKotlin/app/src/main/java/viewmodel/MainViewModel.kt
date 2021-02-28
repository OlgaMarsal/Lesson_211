package viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val liveDataToObserver: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl()
) : ViewModel() {

    fun getLiveData(): LiveData<AppState> = liveDataToObserver

    fun getWeatherFromLocalSource() = getDataFromLocalSource()

    fun getWeatherFromRemoteSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserver.value = AppState.Loading
        Thread {
            sleep(1000)
            val data = repositoryImpl.getWeatherFromLocalStorage()
            liveDataToObserver.postValue(
                    AppState.Success(data)
            )
            liveDataToObserver.postValue(
                    AppState.Error(Throwable("No itnternet"))
            )
        }.start()
    }
}