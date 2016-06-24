package utility;

import org.funtastic.exception.NotValidException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ImgFlipUtils {

	@Value("${imgflip.api.endpoint}")
	private static String IMG_FLIP_REST_ENDPOINT = "https://api.imgflip.com/";

	public static String getMeme() throws NotValidException {
		return RestApiUtils.get(IMG_FLIP_REST_ENDPOINT + "get_memes");
	}
}
