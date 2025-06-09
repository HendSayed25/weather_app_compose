package com.example.weather_app_compose.presentaion.weather_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app_compose.R
import com.example.weather_app_compose.ui.theme.darkGray

@Composable
fun LocationDesign(){
    Row(modifier = Modifier.padding(start = 133.dp, end = 133.dp, top = 64.dp, bottom = 12.dp)){

        Image(
            painter = painterResource(R.drawable.location),
            contentDescription = "location icon"
        )
        Box (Modifier.padding(start = 4.dp, top = 2.dp, bottom = 2.dp)){
            Text(
                text = "Cairo" ,//will change based in location,
                fontWeight = FontWeight.W500,
                fontSize = 16.sp,
                color = darkGray
            )

        }

    }
}