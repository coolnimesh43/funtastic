/**
 * 
 */
package utility;

import org.funtastic.enums.GiphyType;
import org.funtastic.exception.NotValidException;
import org.springframework.beans.factory.annotation.Value;

import com.google.gson.JsonObject;

/**
 * @author adhpawal
 *
 */
public class GiphyUtils {

	@Value("${giphy.access.key}")
	private static String GIPHY_PUBLIC_KEY = "dc6zaTOxFJmzC";

	@Value("${giphy.api.endpoint}")
	private static String GIPHY_REST_ENDPOINT = "http://api.giphy.com/v1/";

	/**
	 * Fetch Giphy Response for given {@link GiphyType}.
	 * 
	 * @param type
	 *            : {@link GiphyType}
	 * @param searchTerm
	 *            : {@link String}
	 * @return {@link JsonObject}
	 * @throws NotValidException
	 */
	public static String get(GiphyType type, String... searchTerm) throws NotValidException {
		final String uri = createGiphyEndpoint(type, searchTerm);
		return RestApiUtils.get(uri);
	}

	/**
	 * Create Giphy REST Endpoints.
	 * 
	 * @param type
	 * @param searchTerm
	 * @return
	 */
	private static String createGiphyEndpoint(GiphyType type, String... searchTerm) {
		String endPoint = GIPHY_REST_ENDPOINT;
		String term = searchTerm.length > 0 ? searchTerm[0] : "";
		switch (type) {
		case SEARCH:
			endPoint = endPoint + "gifs/search" + "?q=" + term + "&api_key=" + GIPHY_PUBLIC_KEY;
			break;
		case TRENDING:
			endPoint = endPoint + "gifs/trending" + "?api_key=" + GIPHY_PUBLIC_KEY;
			break;
		case STICKERS:
			endPoint = endPoint + "stickers/trending" + "?api_key=" + GIPHY_PUBLIC_KEY;
			break;
		case RANDOM:
			endPoint = endPoint + "gifs/random" + "?api_key=" + GIPHY_PUBLIC_KEY;
			break;
		default:
			break;
		}
		return endPoint;
	}
}
