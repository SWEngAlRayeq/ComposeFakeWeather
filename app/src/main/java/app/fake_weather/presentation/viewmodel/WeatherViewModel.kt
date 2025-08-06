package app.fake_weather.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.fake_weather.data.model.WeatherUiState
import app.fake_weather.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    var uiState by mutableStateOf(WeatherUiState())
        private set


    fun fetchWeather(city: String) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)
            try {
                val weather = getWeatherUseCase(city)
                uiState = uiState.copy(
                    temperature = weather.temperature,
                    wind = weather.wind,
                    description = weather.description,
                    isLoading = false
                )
            } catch (e: Exception) {
                uiState = uiState.copy(error = e.localizedMessage, isLoading = false)
            }
        }
    }

}