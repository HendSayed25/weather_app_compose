package com.example.weather_app_compose

import Next7DaysForecastCard
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.weather_app_compose.ui.theme.skyBlue
import com.example.weather_app_compose.ui.theme.textColorTitle
import com.example.weather_app_compose.ui.theme.white
import com.example.weather_app_compose.weather_component.CurrentWeather
import com.example.weather_app_compose.weather_component.LocationDesign
import com.example.weather_app_compose.weather_component.WeatherStateContent

@Preview
@Composable
fun WeatherScreen() {
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
            ).padding(top = 15.dp),
        contentAlignment = Alignment.TopCenter

    ){
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            item { LocationDesign() }
            item { CurrentWeather() }
            item {
              WeatherStateContent()
            }
            stickyHeader {
                Text(
                    text = "Today",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = textColorTitle,
                    modifier = Modifier.padding(bottom = 5.dp, start = 12.dp).fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }
            item {
            LazyRow (
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp))
               {
               items(7){
                   WeatherForecastCard(
                       painterResource(R.drawable.weather_icon),
                       "27 C",
                       "11:00"
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
                    modifier = Modifier.padding(start = 12.dp, bottom = 5.dp).fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }

            item{
                Next7DaysForecastCard()
            }
            item{
                Spacer(Modifier.height(50.dp))
            }



        }
    }
}

