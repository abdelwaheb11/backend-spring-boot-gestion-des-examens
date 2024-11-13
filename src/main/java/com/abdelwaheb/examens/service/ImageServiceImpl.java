package com.abdelwaheb.examens.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import com.abdelwaheb.examens.entities.Examen;
import com.abdelwaheb.examens.entities.Image;
import com.abdelwaheb.examens.repos.ImageRepository;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ExamenService examenService;

   @Override
	public Image uplaodImage(MultipartFile file) throws IOException {
		/*Ce code commenté est équivalent au code utilisant le design pattern Builder
		* Image image = new Image(null, file.getOriginalFilename(),
		file.getContentType(), file.getBytes(), null);
		return imageRepository.save(image);*/
		return imageRepository.save(Image.builder()
			.name(file.getOriginalFilename())
			.type(file.getContentType())
			.image(file.getBytes()).build() );
	}

	@Override
	public Image getImageDetails(Long id) throws IOException{
	final Optional<Image> dbImage = imageRepository.findById(id);
	return Image.builder()
		.idImage(dbImage.get().getIdImage())
		.name(dbImage.get().getName())
		.type(dbImage.get().getType())
		.image(dbImage.get().getImage()).build() ;
	}

	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException{
		final Optional<Image> dbImage = imageRepository. findById (id);
		return ResponseEntity.ok()
			.contentType(MediaType.valueOf(dbImage.get().getType()))
			.body(dbImage.get().getImage());
	}

	@Override
	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}

	@Override
	public Image uplaodImageExamen(MultipartFile file,Long idExamen)throws IOException {
		Examen e = new Examen();
		e.setId(idExamen);
		return imageRepository.save(Image.builder()
			.name(file.getOriginalFilename())
			.type(file.getContentType())
			.image(file.getBytes())
			.examen(e).build() );
	}

	@Override
	public List<Image> getImagesParExamen(Long idExamen) {
		return imageRepository.findAllByExamen_Id(idExamen);
	}

	@Override
	public void deleteImagesByExamen(Long examneId) {
		imageRepository.deleteByExamen_Id(examneId);
	}

}
