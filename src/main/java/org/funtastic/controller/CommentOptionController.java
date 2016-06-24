/**
 * 
 */
package org.funtastic.controller;

import org.funtastic.enums.GiphyType;
import org.funtastic.exception.NotValidException;
import org.funtastic.utility.GiphyUtils;
import org.funtastic.utility.ImgFlipUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author adhpawal
 *
 */

@Controller
@RequestMapping("/comment")
public class CommentOptionController {

	@Value("${imgflip.api.endpoint}")
	private String IMG_FLIP_REST_ENDPOINT = "https://api.imgflip.com/";

	@Value("${giphy.access.key}")
	private static String GIPHY_PUBLIC_KEY = "dc6zaTOxFJmzC";

	@Value("${giphy.api.endpoint}")
	private static String GIPHY_REST_ENDPOINT = "http://api.giphy.com/v1/";

	@RequestMapping(value = "/meme", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> getMeme() throws NotValidException {
		return new ResponseEntity<>(ImgFlipUtils.getMeme(IMG_FLIP_REST_ENDPOINT + "get_memes"), HttpStatus.OK);
	}

	@RequestMapping(value = "/gif/{type}/{searchTerm}", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("type") String type, @PathVariable("searchTerm") String term)
			throws NotValidException {
		return new ResponseEntity<>(
				GiphyUtils.get(GIPHY_PUBLIC_KEY, GIPHY_REST_ENDPOINT, GiphyType.getEnum(type), term), HttpStatus.OK);
	}
}
