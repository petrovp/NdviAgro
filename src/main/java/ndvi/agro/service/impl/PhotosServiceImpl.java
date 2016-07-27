package ndvi.agro.service.impl;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;

import ndvi.agro.persistance.datamodel.Photo;
import ndvi.agro.persistance.repostories.PhotoRepository;
import ndvi.agro.service.PhotosService;
import ndvi.agro.service.exceptions.InvalidFileException;

/**
 * Implementation class for {@link PhotosService} interface.
 * @author Petre
 *
 */
@Service
public class PhotosServiceImpl implements PhotosService {

	@Autowired
	private PhotoRepository photoRepository;
	
	@Override
	public void savePhotos(MultipartFile[] photosForSaving) {
		
		if (photosForSaving == null) {
			throw new InvalidFileException("File for saving are null.");
		}
		
		try {
			List<Photo> photos = Lists.newArrayList();
			for (MultipartFile multipartPhoto : photosForSaving) {
				Photo photo = createPhotoFromMultipartFile(multipartPhoto);
				photos.add(photo);
			}
			photoRepository.save(photos);
			
		} catch (Exception e) {
			throw new InvalidFileException("Invalid file exception", e);
		} 
		
	}

	private Photo createPhotoFromMultipartFile(MultipartFile multipartPhoto)
			throws SerialException, SQLException, IOException {
		Blob fileBlob = new SerialBlob(multipartPhoto.getBytes());
		
		Photo photo = new Photo();
		photo.setContent(fileBlob);
		photo.setFileName(multipartPhoto.getName());
		photo.setCreationDate(new Date());
		photo.setType("1");
		photo.setContentType(multipartPhoto.getContentType());
		return photo;
	}

}
