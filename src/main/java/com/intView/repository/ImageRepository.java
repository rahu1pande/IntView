package com.intView.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intView.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{
	
}
