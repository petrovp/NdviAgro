package ndvi.agro.persistance.datamodel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

@MappedSuperclass
public class BaseEntity {

    @TableGenerator(name="ID_GENERATOR",
            table="GENERATED_KEYS",
            pkColumnName="PK_COLUMN",
            valueColumnName="VALUE_COLUMN",
            pkColumnValue="ENTITY_ID",
            allocationSize=1,
            initialValue = 10000
    )
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ID_GENERATOR")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
