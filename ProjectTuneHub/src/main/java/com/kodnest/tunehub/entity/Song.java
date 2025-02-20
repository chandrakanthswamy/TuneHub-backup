package com.kodnest.tunehub.entity;

import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String artist;
    String genre;
    String Link;
    @ManyToMany
    List<Playlist> playlist;
    
    public Song() {
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public List<Playlist> getPlaylist() {
		return playlist;
	}
	public void setPlaylist(List<Playlist> playlist) {
		this.playlist = playlist;
	}
	public Song(int id, String name, String artist, String genre, String link, List<Playlist> playlist) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.Link = link;
		this.playlist = playlist;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", Link=" + Link
				+ ", playlist=" + playlist + "]";
	}
	
}


