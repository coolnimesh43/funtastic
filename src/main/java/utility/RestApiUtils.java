package utility;

import org.funtastic.enums.GiphyType;
import org.funtastic.exception.NotValidException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RestApiUtils {

	/**
	 * Perform GET operation.
	 * 
	 * @param uri
	 * @return
	 * @throws NotValidException
	 */
	public static String get(String uri) throws NotValidException {
		RestTemplate restTemplate = new RestTemplate();
		String result = null;
		try {
			result = restTemplate.getForObject(uri, String.class);
		} catch (RestClientException rce) {
			rce.printStackTrace();
			throw new NotValidException("Invalid");
		}
		return result;
	}

	/**
	 * Perform GET operation.
	 * 
	 * @param uri
	 * @return
	 * @throws NotValidException
	 */
	public static String getRest(String uri) throws NotValidException {
		RestTemplate restTemplate = new RestTemplate();
		String result = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("User-Agent", "ozilla/4.0");
			HttpEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity(headers),
					String.class);
			result = response.getBody();
		} catch (RestClientException rce) {
			rce.printStackTrace();
			throw new NotValidException("Invalid");
		}
		return result;
	}

}
