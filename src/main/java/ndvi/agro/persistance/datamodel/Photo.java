package ndvi.agro.persistance.datamodel;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Entity(name = "photo")
public class Photo extends BaseEntity {

	@NotNull
	@Column(nullable = false, length = 100)
	private String type;

	@NotNull
	@Column(nullable = false, length = 100)
	private String fileName;

	@NotNull
	@Column(nullable = false)
	private Date creationDate;

	@NotNull
	@Column(nullable = false)
	private Blob content;

	@NotNull
	@Column(nullable = false, length = 100)
	private String contentType;

	private double latitude;

	private double longitude;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
