package com.song.chord.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "song_id")
    @ElementCollection
    private List<SongLine> linesTamil;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tanglish_song_id")
    @ElementCollection
    private List<SongLine> linesTanglish;

    public Song() {
    }

    public Song(Long id, String title, List<SongLine> linesTamil, List<SongLine> linesTanglish) {
        this.id = id;
        this.title = title;
        this.linesTamil = linesTamil;
        this.linesTanglish = linesTanglish;
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
}
