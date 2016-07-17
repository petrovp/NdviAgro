package ndvi.agro.persistance.datamodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


@Entity(name = "photo")
public class Photo extends BaseEntity{

	@NotNull
	@Column(nullable = false, length = 100)
	private String type;

	@NotNull
	@Column(name = "creationDate")
	private Date creationDate;

	@NotNull
	private byte[] content;

	@NotNull
	private double latitude;

	@NotNull
	private double longitude;

}
