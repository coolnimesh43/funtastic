/**
 * 
 */
package org.funtastic.controller;

import org.funtastic.enums.GiphyType;
import org.funtastic.exception.NotValidException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import utility.GiphyUtils;
import utility.ImgFlipUtils;

/**
 * @author adhpawal
 *
 */

@Controller
@RequestMapping("/comment")
public class CommentOptionController {

	@RequestMapping(value = "/meme", method = RequestMethod.GET)
	@ResponseBody
	public String getMeme() throws NotValidException {
		System.out.println("paal");
		return ImgFlipUtils.getMeme();
	}

	@RequestMapping(value = "/gif/{type}/{searchTerm}", method = RequestMethod.GET)
	@ResponseBody
	public String get(@PathVariable("type") String type, @PathVariable("searchTerm") String term)
			throws NotValidException {
		return GiphyUtils.get(GiphyType.getEnum(type), term);
	}
}
