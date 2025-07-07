package com.song.chord.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class SongLine {
    private String chordLine;
    private String lyricLine;

    public SongLine() {
    }

    public SongLine(String chordLine, String lyricLine) {
        this.chordLine = chordLine;
        this.lyricLine = lyricLine;
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
}
