package com.song.chord.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

//@Embeddable

@Entity
@Embeddable
public class SongLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chordLine;
    private String lyricLine;

    public SongLine() {
    }

    @ManyToOne
    @JoinColumn(name = "song_id")
    //@JsonIgnore
    //@JsonManagedReference
    @JsonBackReference
    private Song song;

    /*public SongLine(Long id, String chordLine, String lyricLine, Song song) {
        this.id = id;
        this.chordLine = chordLine;
        this.lyricLine = lyricLine;
        this.song = song;
    }*/
// 2-arg constructor
    public SongLine(String chordLine, String lyricLine) {
        this.chordLine = chordLine;
        this.lyricLine = lyricLine;
    }

    public SongLine(Long id, String chordLine, String lyricLine) {
        this.id = id;
        this.chordLine = chordLine;
        this.lyricLine = lyricLine;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChordLine() {
        return chordLine;
    }

    public void setChordLine(String chordLine) {
        this.chordLine = chordLine;
    }

    public String getLyricLine() {
        return lyricLine;
    }

    public void setLyricLine(String lyricLine) {
        this.lyricLine = lyricLine;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
