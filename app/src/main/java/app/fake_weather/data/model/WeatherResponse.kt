package app.fake_weather.data.model

data class WeatherResponse(
    val temperature: String,
    val wind: String,
    val description: String,
    val forecast: List<Forecast> = emptyList()
)


data class Forecast(
    val day: String,
    val temperature: String,
    val wind: String
)