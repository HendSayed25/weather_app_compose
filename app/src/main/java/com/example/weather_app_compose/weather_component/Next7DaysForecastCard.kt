import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weather_app_compose.R
import com.example.weather_app_compose.ui.theme.lightGray
import com.example.weather_app_compose.ui.theme.white
import com.example.weather_app_compose.weather_component.DailyForecastItem

@Composable
fun Next7DaysForecastCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = white.copy(0.7f)),
        border = BorderStroke(width = 1.dp, color = lightGray),
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {
            DailyForecastItem(day = "Monday", iconPainter = painterResource(id = R.drawable.weather_icon), maxTemp = "32°C", minTemp = "20°C") //
            DailyForecastItem(day = "Tuesday", iconPainter = painterResource(id = R.drawable.weather_icon), maxTemp = "32°C", minTemp = "20°C") //
            DailyForecastItem(day = "Wednesday", iconPainter = painterResource(id = R.drawable.weather_icon), maxTemp = "32°C", minTemp = "20°C") //
            DailyForecastItem(day = "Thursday", iconPainter = painterResource(id = R.drawable.weather_icon), maxTemp = "32°C", minTemp = "20°C") //
            DailyForecastItem(day = "Friday", iconPainter = painterResource(id = R.drawable.weather_icon), maxTemp = "32°C", minTemp = "20°C") //
            DailyForecastItem(day = "Saturday", iconPainter = painterResource(id = R.drawable.weather_icon), maxTemp = "32°C", minTemp = "20°C") //
            DailyForecastItem(day = "Sunday", iconPainter = painterResource(id = R.drawable.weather_icon), maxTemp = "32°C", minTemp = "20°C") //
        }
    }
}