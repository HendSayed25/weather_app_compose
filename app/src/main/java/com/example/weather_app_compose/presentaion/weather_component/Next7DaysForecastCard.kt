import android.os.Build
import androidx.annotation.RequiresApi
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
import com.example.weather_app_compose.presentaion.models.DailyForecastItem
import com.example.weather_app_compose.ui.theme.lightGray
import com.example.weather_app_compose.ui.theme.white
import com.example.weather_app_compose.presentaion.weather_component.DailyForecastItem
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Next7DaysForecastCard(
    dailyForecastItems : List<DailyForecastItem>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = white.copy(0.7f)),
        border = BorderStroke(width = 1.dp, color = lightGray),
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {
            DailyForecastItem(day = getDayName(dailyForecastItems[0].day), iconPainter = painterResource(dailyForecastItems[0].imageId), maxTemp = "${dailyForecastItems[0].maxTemp}°C", minTemp = "${dailyForecastItems[0].minTemp}°C") //
            DailyForecastItem(day = getDayName(dailyForecastItems[1].day), iconPainter = painterResource(dailyForecastItems[1].imageId), maxTemp = "${dailyForecastItems[1].maxTemp}°C", minTemp = "${dailyForecastItems[1].minTemp}°C") //
            DailyForecastItem(day = getDayName(dailyForecastItems[2].day), iconPainter = painterResource(dailyForecastItems[2].imageId), maxTemp = "${dailyForecastItems[2].maxTemp}°C", minTemp = "${dailyForecastItems[2].minTemp}°C") //
            DailyForecastItem(day = getDayName(dailyForecastItems[3].day), iconPainter = painterResource(dailyForecastItems[3].imageId), maxTemp = "${dailyForecastItems[3].maxTemp}°C", minTemp = "${dailyForecastItems[3].minTemp}°C") //
            DailyForecastItem(day = getDayName(dailyForecastItems[4].day), iconPainter = painterResource(dailyForecastItems[4].imageId), maxTemp = "${dailyForecastItems[4].maxTemp}°C", minTemp = "${dailyForecastItems[4].minTemp}°C") //
            DailyForecastItem(day = getDayName(dailyForecastItems[5].day), iconPainter = painterResource(dailyForecastItems[5].imageId), maxTemp = "${dailyForecastItems[5].maxTemp}°C", minTemp = "${dailyForecastItems[5].minTemp}°C") //
            DailyForecastItem(day = getDayName( dailyForecastItems[6].day), iconPainter = painterResource(dailyForecastItems[6].imageId), maxTemp = "${dailyForecastItems[6].maxTemp}°C", minTemp = "${dailyForecastItems[6].minTemp}°C") //
        }
    }
}


fun getDayName(dateString: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val date: Date? = inputFormat.parse(dateString)

    val outputFormat = SimpleDateFormat("EEEE", Locale.getDefault()) // EEEE = Full day name
    return if (date != null) outputFormat.format(date) else "Unknown"
}