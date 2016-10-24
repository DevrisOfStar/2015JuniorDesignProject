import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;


public class Map {
	
	public static void main(String[] args)
	{
		// Replace the API key below with a valid API key.
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAxwRamS7BllJxmzpMUSndLeOIXD5iOqwM ");
		GeocodingResult[] results = {};
		try{
		results =  GeocodingApi.geocode(context,
		    "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
		}catch(Exception e)
		{};
		System.out.println(results[0].formattedAddress);
	}

}
