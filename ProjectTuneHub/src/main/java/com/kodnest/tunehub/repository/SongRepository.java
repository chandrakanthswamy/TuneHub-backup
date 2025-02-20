package com.kodnest.tunehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.tunehub.entity.Song;

public interface SongRepository 
extends JpaRepository<Song, Integer> {
	
	List<Song> findByName(String name);
}
