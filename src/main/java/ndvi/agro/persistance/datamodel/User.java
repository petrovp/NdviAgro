package ndvi.agro.persistance.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity(name = "user")
public class User extends BaseEntity {

	@NotNull
	@Column(nullable = false, unique = true, length = 100)
	private String username;

	@NotNull
	@Column(nullable = false, length = 100)
	private String password;
	
	@ManyToOne(targetEntity = Authority.class, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "authority_id", nullable = true)
    private Authority authority;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

}
