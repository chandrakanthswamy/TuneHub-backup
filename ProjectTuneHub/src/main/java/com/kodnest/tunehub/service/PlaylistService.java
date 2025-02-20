package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.Playlist;

public interface PlaylistService {

	public List<Playlist> fetchAllPlaylists();

	public void addplaylist(Playlist playlist);

	}
