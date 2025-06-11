package com.example.weather_app_compose.presentaion.weather_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.weather_app_compose.R
import com.example.weather_app_compose.ui.theme.darkGray
import com.example.weather_app_compose.ui.theme.dividerColor
import com.example.weather_app_compose.ui.theme.lightGray
import com.example.weather_app_compose.ui.theme.veryLightGray

@Composable
fun MinMaxDegree(
    maxTemp : String,
    minTemp : String,
    isDay : Int
) {
    Box(
        Modifier.clip(RoundedCornerShape(50.dp))
            .background(MaterialTheme.colorScheme.onBackground).
    padding(vertical = 8.dp, horizontal = 18.dp )
    ){
        Row(verticalAlignment = Alignment.CenterVertically){
            Row(verticalAlignment = Alignment.CenterVertically){
                CardContent(painterResource(if (isDay == 1) R.drawable.arrow_top else R.drawable.arrow_top_drak), "$maxTemp°C",)
            }

            Box(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .width(1.dp)
                    .height(16.dp)
                    .background(MaterialTheme.colorScheme.outline)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                CardContent(painterResource(if (isDay == 1) R.drawable.arrow_down else R.drawable.arrow_down_dark), "$minTemp°C")
            }

        }
    }
}

@Composable
private fun CardContent(
    icon : Painter,
    text : String
){
    Image(
        painter = icon,
        contentDescription = "arrow"
    )

    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.W500,
        modifier = Modifier.padding(start = 4.dp),
        color = MaterialTheme.colorScheme.surface
    )
}