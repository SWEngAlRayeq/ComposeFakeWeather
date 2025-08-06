package app.fake_weather.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.fake_weather.presentation.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = hiltViewModel()) {

    val state = viewModel.uiState
    var city by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("🌤️ Weather Generator", fontSize = 22.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Enter city") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {viewModel.fetchWeather(city)},
            modifier = Modifier.fillMaxWidth()) {
            Text("Get Weather")
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (state.isLoading) {
            CircularProgressIndicator()
        } else if (state.error != null) {
            Text("Error: ${state.error}", color = Color.Red)
        } else {
            Text("Temperature: ${state.temperature}")
            Text("Wind: ${state.wind}")
            Text("Description: ${state.description}")
        }

    }


}