import com.example.weather_app_compose.data.remote.datasource.ILocationRemoteDataSource
import com.example.weather_app_compose.logic.entities.Location
import com.example.weather_app_compose.logic.repository.ILocationRepository


class LocationRepositoryImp(
    private val locationRemoteDataSource: ILocationRemoteDataSource
) : ILocationRepository {

    override suspend fun getCurrentLocation(): Location {
        return locationRemoteDataSource.getCurrentLocation()
    }
}
