package ndvi.agro.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Service for manipulation with the photos.
 * @author Petre
 *
 */
public interface PhotosService {

	void savePhotos(MultipartFile [] photosForSaving);
}
