package com.example.weather_app_compose.presentaion.weather_component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.weather_app_compose.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DailyForecastItem(
    day: String,
    iconPainter: Painter,
    maxTemp: Double,
    minTemp: Double,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = day,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier.weight(1f)
            )

            Icon(
                painter = iconPainter,
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(40.dp)
            )

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_top),
                    contentDescription = "Max temp icon",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "${maxTemp.toInt()}°C",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Box(
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp)
                        .width(1.dp)
                        .height(16.dp)
                        .background(MaterialTheme.colorScheme.outline)
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_down),
                    contentDescription = "Min temp icon",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(Modifier.width(2.dp))

                Text(
                    text = "${minTemp.toInt()}°C",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

    }
}



