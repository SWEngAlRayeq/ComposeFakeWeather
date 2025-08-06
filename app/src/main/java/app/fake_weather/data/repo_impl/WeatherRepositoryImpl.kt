package app.fake_weather.data.repo_impl

import app.fake_weather.data.api.WeatherApiService
import app.fake_weather.data.model.WeatherResponse
import app.fake_weather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApiService: WeatherApiService
) : WeatherRepository {
    override suspend fun getWeather(city: String): WeatherResponse {
        return weatherApiService.getWeather(city)
    }
}