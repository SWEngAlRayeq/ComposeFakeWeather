package app.fake_weather.domain.repository

import app.fake_weather.data.model.WeatherResponse

interface WeatherRepository {
    suspend fun getWeather(city: String): WeatherResponse
}