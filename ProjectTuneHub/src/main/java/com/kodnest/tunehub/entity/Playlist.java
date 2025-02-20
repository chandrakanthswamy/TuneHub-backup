package com.kodnest.tunehub.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Playlist {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String name;
    
    @ManyToMany
    private List<Song> songList = new ArrayList<>();

    // Constructors, Getters, and Setters

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

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public Playlist(int id, String name, List<Song> songList) {
        super();
        this.id = id;
        this.name = name;
        this.songList = songList;
    }

    @Override
    public String toString() {
        return "Playlist [id=" + id + ", name=" + name + ", songList=" + songList + "]";
    }

    public Playlist() {
        super();
    }
}
