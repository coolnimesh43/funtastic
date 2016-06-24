package utility;

import org.funtastic.exception.NotValidException;
import org.springframework.beans.factory.annotation.Value;

import com.google.gson.JsonObject;

public class ImgFlipUtils {

	@Value("${imgflip.api.endpoint}")
	private static String IMG_FLIP_REST_ENDPOINT;

	public static String getMeme() throws NotValidException {
		return RestApiUtils.get(IMG_FLIP_REST_ENDPOINT + "get_memes");
	}
}
