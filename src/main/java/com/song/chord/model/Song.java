package com.song.chord.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ElementCollection
    @CollectionTable(name = "lines_tamil", joinColumns = @JoinColumn(name = "song_id"))
    private List<SongLine> linesTamil;

    @ElementCollection
    @CollectionTable(name = "lines_tanglish", joinColumns = @JoinColumn(name = "song_id"))
    private List<SongLine> linesTanglish;

    public Song() {
    }

    public Song(String title, List<SongLine> linesTamil, List<SongLine> linesTanglish) {
        this.title = title;
        this.linesTamil = linesTamil;
        this.linesTanglish = linesTanglish;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<SongLine> getLinesTamil() {
        return linesTamil;
    }

    public List<SongLine> getLinesTanglish() {
        return linesTanglish;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLinesTamil(List<SongLine> linesTamil) {
        this.linesTamil = linesTamil;
    }

    public void setLinesTanglish(List<SongLine> linesTanglish) {
        this.linesTanglish = linesTanglish;
    }
}
