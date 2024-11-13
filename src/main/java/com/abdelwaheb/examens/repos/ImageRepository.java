package com.abdelwaheb.examens.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdelwaheb.examens.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByExamen_Id(Long examenId);
    void deleteByExamen_Id(Long examenId);
    

}
