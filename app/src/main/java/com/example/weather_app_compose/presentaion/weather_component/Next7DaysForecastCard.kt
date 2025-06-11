
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weather_app_compose.presentaion.models.DailyForecastItem
import com.example.weather_app_compose.presentaion.weather_component.DailyForecastItem


@Composable
fun Next7DaysForecastCard(
    dailyForecastItems : List<DailyForecastItem>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onTertiary),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onBackground),
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {

            for (i in 0..6) {
                DailyForecastItem(
                    day = dailyForecastItems[i].day,
                    iconPainter = painterResource(dailyForecastItems[i].imageId),
                    maxTemp = "${dailyForecastItems[i].maxTemp}°C",
                    minTemp = "${dailyForecastItems[i].minTemp}°C"
                )
            }
        }
    }
}


