package com.hoxy.datafetch.repository;

import com.hoxy.datafetch.entity.photo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
