package com.song.chord.dto;

import java.util.List;

// SongDTO.java
public class SongDTO {
    private Long id;
    private String title;
    private List<SongLineDTO> linesTamil;
    private List<SongLineDTO> linesTanglish;

    // Getters and setters


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

    public List<SongLineDTO> getLinesTamil() {
        return linesTamil;
    }

    public void setLinesTamil(List<SongLineDTO> linesTamil) {
        this.linesTamil = linesTamil;
    }

    public List<SongLineDTO> getLinesTanglish() {
        return linesTanglish;
    }

    public void setLinesTanglish(List<SongLineDTO> linesTanglish) {
        this.linesTanglish = linesTanglish;
    }
}

