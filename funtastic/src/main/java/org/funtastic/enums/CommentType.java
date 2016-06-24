package org.funtastic.enums;

public enum CommentType {

	TEXT("text"),IMAGE("image"),VIDEO("video"),HTML("html");
	
	private String commentType;
	
	private CommentType(String value){
		this.commentType=value;
	}
	
	public String getCommentType(){
		return this.commentType;
	}
	
	@Override
	public String toString(){
		return this.commentType;
	}
}
