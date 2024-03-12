import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.model.*;

public class RestaurantSearch {

    public static void main(String[] args) {
        // Replace "YOUR_API_KEY" with your actual API key
        String apiKey = "YOUR_API_KEY";

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();

        try {
            // Define the location (latitude and longitude) and radius for the search
            LatLng location = new LatLng(37.7749, -122.4194); // Example: Nairobi
            int radius = 5000; // Radius in meters

            // Perform a nearby search for restaurants
            PlacesSearchResponse result = PlacesApi.nearbySearchQuery(context, location)
                    .radius(radius)
                    .type(PlaceType.RESTAURANT)
                    .await();

            // Display the results
            for (PlacesSearchResult place : result.results) {
                System.out.println("Name: " + place.name);
                System.out.println("Address: " + place.vicinity);
                System.out.println("Rating: " + place.rating);
                System.out.println("----------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
