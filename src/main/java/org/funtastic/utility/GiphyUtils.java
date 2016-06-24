/**
 * 
 */
package org.funtastic.utility;

import org.funtastic.enums.GiphyType;
import org.funtastic.exception.NotValidException;

import com.google.gson.JsonObject;

/**
 * @author adhpawal
 *
 */
public class GiphyUtils {
	
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
	public static String get(String urlEndPoint, String key, GiphyType type, String... searchTerm)
			throws NotValidException {
		final String uri = createGiphyEndpoint("http://api.giphy.com/v1/", "dc6zaTOxFJmzC", type, searchTerm);
		return RestApiUtils.get(uri);
	}

	/**
	 * Create Giphy REST Endpoints.
	 * 
	 * @param type
	 * @param searchTerm
	 * @return
	 */
	private static String createGiphyEndpoint(String urlEndPoint, String key, GiphyType type, String... searchTerm) {
		String endPoint = urlEndPoint;
		String term = searchTerm.length > 0 ? searchTerm[0] : "";
		switch (type) {
		case SEARCH:
			endPoint = endPoint + "gifs/search" + "?q=" + term + "&api_key=" + key;
			break;
		case TRENDING:
			endPoint = endPoint + "gifs/trending" + "?api_key=" + key;
			break;
		case STICKERS:
			endPoint = endPoint + "stickers/trending" + "?api_key=" + key;
			break;
		case RANDOM:
			endPoint = endPoint + "gifs/random" + "?api_key=" + key;
			break;
		default:
			break;
		}
		return endPoint;
	}
}
