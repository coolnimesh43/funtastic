package org.funtastic.enums;

import java.util.HashMap;
import java.util.Map;

public enum GiphyType {

	SEARCH("search"), TRENDING("trending"), STICKERS("stickers"), RANDOM("random");

	String value;

	private static Map<String, GiphyType> giphTypeList = new HashMap<>();

	static {
		for (GiphyType type : GiphyType.values()) {
			giphTypeList.put(type.value, type);

		}
	}

	private GiphyType(String value) {
		this.value = value;
	}

	public String getType() {
		return value;
	}

	public static GiphyType getEnum(String value) {
		return giphTypeList.get(value);
	}
}