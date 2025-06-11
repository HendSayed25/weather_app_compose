package com.example.weather_app_compose.presentaion

import Next7DaysForecastCard
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app_card.WeatherForecastCard
import com.example.weather_app_compose.R
import com.example.weather_app_compose.logic.entities.CurrentWeatherUI
import com.example.weather_app_compose.logic.entities.WeatherState
import com.example.weather_app_compose.presentaion.models.DailyForecastItem
import com.example.weather_app_compose.presentaion.models.HourlyItem
import com.example.weather_app_compose.presentaion.viewmodels.WeatherViewModel
import com.example.weather_app_compose.ui.theme.skyBlue
import com.example.weather_app_compose.ui.theme.textColorTitle
import com.example.weather_app_compose.ui.theme.white
import com.example.weather_app_compose.presentaion.weather_component.CurrentWeather
import com.example.weather_app_compose.presentaion.weather_component.LocationDesign
import com.example.weather_app_compose.presentaion.weather_component.WeatherStateContent
import kotlinx.coroutines.flow.StateFlow
import org.koin.androidx.compose.koinViewModel
import org.koin.mp.KoinPlatform.getKoin



@Preview
@Composable
fun WeatherScreen(
    weatherViewModel: WeatherViewModel = koinViewModel()
) {
    val cityName by weatherViewModel.cityName.collectAsState()
    val currentWeather by weatherViewModel.currentWeather.collectAsState()
    val rainValue by weatherViewModel.rain.collectAsState()
    val windValue by weatherViewModel.wind.collectAsState()
    val uvIndexValue by weatherViewModel.uvIndex.collectAsState()
    val pressureValue by weatherViewModel.pressure.collectAsState()
    val humidityValue by weatherViewModel.humidity.collectAsState()
    val dailyForecastItems by weatherViewModel.dailyForecastItems.collectAsState()

    val hourlyItems by weatherViewModel.dayHoursItems.collectAsState()

    val weatherStates : List<WeatherState> = listOf(
        WeatherState(
            iconId = R.drawable.fast_wind,
            value = "$windValue km/h",
            state = "wind"
        ),
        WeatherState(
            iconId = R.drawable.humidity,
            value = "$humidityValue %",
            state = "Humidity"
        ), WeatherState(
            iconId = R.drawable.rain,
            value = "$rainValue %",
            state = "Rain"
        ), WeatherState(
            iconId = R.drawable.uv,
            value = uvIndexValue,
            state = "UV Index"
        ), WeatherState(
            iconId = R.drawable.arrow_down_blue,
            value = "$pressureValue hPa",
            state = "Pressure"
        ), WeatherState(
            iconId = R.drawable.temperature,
            value = "${currentWeather?.temperature} C",
            state = "Feels like"
        ),

        )


    WeatherContent(
      cityName = cityName,
      currentWeather = currentWeather,
      weatherStates = weatherStates,
        dailyForecastItems = dailyForecastItems,
        hourlyItems= hourlyItems
    )

}

@Composable
private fun WeatherContent(
    cityName: String,
    currentWeather: CurrentWeatherUI?,
    weatherStates : List<WeatherState>,
    dailyForecastItems : List<DailyForecastItem>,
    hourlyItems : List<HourlyItem?>
){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        skyBlue,
                        white
                    )
                )
            )
            .padding(top = 15.dp),
        contentAlignment = Alignment.TopCenter

    ){
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            item { LocationDesign(cityName) }
            item { CurrentWeather(currentWeather) }
            item {
                WeatherStateContent(weatherStates)
            }
            stickyHeader {
                Text(
                    text = "Today",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = textColorTitle,
                    modifier = Modifier
                        .padding(bottom = 5.dp, start = 12.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }
            item {
                LazyRow (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp))
                {
                    items(hourlyItems){ item->
                        WeatherForecastCard(
                            painterResource(item?.imageId?:R.drawable.light_fog),
                            "${item?.temp?.toInt()} C",
                            "${item?.time}"
                        )
                    }
                }
            }

            item{
                Spacer(Modifier.height(60.dp))
            }

            stickyHeader {
                Text(
                    text = "Next 7 days",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = textColorTitle,
                    modifier = Modifier
                        .padding(start = 12.dp, bottom = 5.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }

            item{
                Next7DaysForecastCard(dailyForecastItems)
            }
            item{
                Spacer(Modifier.height(40.dp))
            }

        }
    }
}

