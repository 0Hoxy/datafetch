package com.hoxy.datafetch.repository;

import com.hoxy.datafetch.entity.album.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
