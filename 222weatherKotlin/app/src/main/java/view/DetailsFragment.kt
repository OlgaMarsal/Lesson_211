package view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import model.Weather
import viewmodel.AppState
import viewmodel.MainViewModel

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.getRoot()
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       val weather = arguments7.getParcelable<Weather>(BUNDLE_EXTRA)
        if (weather != null) {
            val city = weather.city
            binding.cityName.text = city.city
            binding.cityCoordinates.text = String.format(
                    getString(R.string.city_coordinates),
                    city.lat.toString(),
                    city.lon.toString()
            )
            binding.temperatureValue.text = weather.temperature.toString()
            binding.feelsLikeValue.text = weather.feelslike.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val  BUNDLE_EXTRA = "weather"

        fun newInstance(bundle: Bundle) = DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }

        fun newInstance(weather: Weather) DetailsFragment {
            val fragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable(BUNDLE_EXTRA, weather)
            fragment.arguments = bundle
            return fragment
        }

    }
}