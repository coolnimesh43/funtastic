package org.funtastic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="image")
public class Image extends AbstractEntity{

	@Column(name = "url")
    private String url;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "content_length")
    private Long contentLength;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "original_file_name")
    private String originalFileName;

	public Image(String url, String fileName, String mimeType, Long contentLength, Boolean isActive,
			String originalFileName) {
		super();
		this.url = url;
		this.fileName = fileName;
		this.mimeType = mimeType;
		this.contentLength = contentLength;
		this.isActive = isActive;
		this.originalFileName = originalFileName;
	}

	public Image() {
		super();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Long getContentLength() {
		return contentLength;
	}

	public void setContentLength(Long contentLength) {
		this.contentLength = contentLength;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
    
}
