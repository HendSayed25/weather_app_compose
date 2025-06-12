package com.example.weather_app_compose.presentaion.weather_component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WeatherForecastCard(
    iconPainter: Painter,
    temperature: Int?,
    time: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(90.dp)
            .height(110.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .offset(y = 30.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onTertiary),
            border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onBackground),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "${temperature}°C",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    color =MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = time,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    color = MaterialTheme.colorScheme.background,
                )
            }
        }

        Icon(
            painter = iconPainter,
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .size(60.dp)
                .offset(y = (10).dp)
        )
    }
}


