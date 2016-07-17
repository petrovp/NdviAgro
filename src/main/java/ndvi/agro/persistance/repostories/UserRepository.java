package ndvi.agro.persistance.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import ndvi.agro.persistance.datamodel.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByUsername(String username);
}
