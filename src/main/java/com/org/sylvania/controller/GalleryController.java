package com.org.sylvania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.sylvania.service.GalleryService;

@RestController
@RequestMapping("/gallery")
public class GalleryController {
	@Autowired
	private GalleryService galleryService;
	@GetMapping("/Pictures")
	public ResponseEntity<String> getListOfPictures() {
		galleryService.getListOfPictures();
		return null;
		
	}
	
	@GetMapping("/picture/{id}")
	public ResponseEntity<String> getPicture() {
		galleryService.getPicture();
		return null;
		
	}
	
	@PostMapping("/picture")
	public ResponseEntity<String> savePicture() {
		galleryService.savePicture();
		return null;
		
	}
	
	@DeleteMapping("picture/{id}")
	public ResponseEntity<String> deletePicture(){
		galleryService.deletePicture();
		return null;
		
	}

}
