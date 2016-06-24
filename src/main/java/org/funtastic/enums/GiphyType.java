package org.funtastic.enums;

public enum GiphyType {

	SEARCH("search"), TRENDING("trending"), STICKERS("stickers"), RANDOM("random");

	String value;

	private GiphyType(String value) {
		this.value = value;
	}

	public String getType() {
		return value;
	}
}