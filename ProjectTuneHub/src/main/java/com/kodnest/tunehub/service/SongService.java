package com.kodnest.tunehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.SongRepository;
import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public boolean songExists(String name) {
        List<Song> songs = songRepository.findByName(name);
        return !songs.isEmpty();  // Check if list is not empty
    }

    public void addSong(Song song) {
        songRepository.save(song);
    }

    public List<Song> fetchAllSongs() {
        return songRepository.findAll();
    }

	public void updateSong(Song s) {
		songRepository.save(s);
		
	}
}
