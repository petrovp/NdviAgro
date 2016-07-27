package ndvi.agro.persistance.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import ndvi.agro.persistance.datamodel.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long>{

}
