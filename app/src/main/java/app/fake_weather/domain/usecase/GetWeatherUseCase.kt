package app.fake_weather.domain.usecase

import app.fake_weather.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(city: String) = weatherRepository.getWeather(city)
}