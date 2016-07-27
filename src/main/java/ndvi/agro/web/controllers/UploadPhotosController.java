package ndvi.agro.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ndvi.agro.service.PhotosService;

@Controller
public class UploadPhotosController {

	@Autowired
	private PhotosService photosService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView showMessage() {
		
		ModelAndView mv = new ModelAndView("uploadImages");
		return mv;
	}
	
	@RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
	public ModelAndView shouldUplodFiles(@RequestParam("files") MultipartFile[] photosForSaving) {
		
		photosService.savePhotos(photosForSaving);
		
		return new ModelAndView("uploadImages");
	}
}
