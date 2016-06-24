package org.funtastic.utility;

import org.funtastic.exception.NotValidException;

public class ImgFlipUtils {
	public static String getMeme(String url) throws NotValidException {
		return RestApiUtils.getRest("https://api.imgflip.com/get_memes");
	}
}
