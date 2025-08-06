package app.fake_weather.data.api

import app.fake_weather.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApiService {

    @GET("weather/{city}")
    suspend fun getWeather(@Path("city") city: String): WeatherResponse

}