package com.song.chord.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

//    @ElementCollection
//    private List<SongLine> lines;


    //@OneToMany(mappedBy = "song", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SongLine> lines;
    // Getters and Setters

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SongLine> linesTamil;

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SongLine> linesTanglish;

    public List<SongLine> getLinesTamil() {
        return linesTamil;
    }

    public void setLinesTamil(List<SongLine> linesTamil) {
        this.linesTamil = linesTamil;
    }

    public List<SongLine> getLinesTanglish() {
        return linesTanglish;
    }

    public void setLinesTanglish(List<SongLine> linesTanglish) {
        this.linesTanglish = linesTanglish;
    }

    public Song() {
    }

    public Song(Long id, String title, List<SongLine> lines, List<SongLine> linesTamil, List<SongLine> linesTanglish) {
        this.id = id;
        this.title = title;
        this.lines = lines;
        this.linesTamil = linesTamil;
        this.linesTanglish = linesTanglish;
    }

    public Song(Long id, String title, List<SongLine> lines) {
        this.id = id;
        this.title = title;
        this.lines = lines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SongLine> getLines() {
        return lines;
    }

    public void setLines(List<SongLine> lines) {
        this.lines = lines;
    }
}



