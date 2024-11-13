package com.abdelwaheb.examens.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.abdelwaheb.examens.entities.Image;

public interface ImageService {
	Image uplaodImage(MultipartFile file) throws IOException;
    Image getImageDetails(Long id) throws IOException;
    ResponseEntity<byte[]> getImage(Long id) throws IOException;
    void deleteImage(Long id) ;
    Image uplaodImageExamen(MultipartFile file,Long id) throws IOException;
    List<Image> getImagesParExamen(Long examenId);
    void deleteImagesByExamen(Long examneId) ;
}
