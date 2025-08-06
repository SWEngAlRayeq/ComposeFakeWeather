package app.fake_weather.data.model

data class WeatherUiState(
    val temperature: String = "",
    val wind: String = "",
    val description: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)
