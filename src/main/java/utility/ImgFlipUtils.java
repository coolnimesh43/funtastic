package utility;

import org.funtastic.exception.NotValidException;

public class ImgFlipUtils {

	public static String getMeme(String url) throws NotValidException {
		return RestApiUtils.get(url);
	}
}
