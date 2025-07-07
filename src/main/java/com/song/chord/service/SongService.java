package com.song.chord.service;

import com.song.chord.model.Song;
import com.song.chord.model.SongLine;
import com.song.chord.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Optional<Song> getSongById(Long id) {
        return songRepository.findById(id);
    }

    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    public List<SongLine> getLinesByLanguage(Long songId, String language) {
        Optional<Song> optionalSong = songRepository.findById(songId);
        if (optionalSong.isEmpty()) return null;

        Song song = optionalSong.get();

        switch (language.toLowerCase()) {
            case "tamil":
                return song.getLinesTamil() != null && !song.getLinesTamil().isEmpty()
                        ? song.getLinesTamil()
                        : List.of(new SongLine("", "Tamil version is not available"));
            case "tanglish":
                return song.getLinesTanglish() != null && !song.getLinesTanglish().isEmpty()
                        ? song.getLinesTanglish()
                        : List.of(new SongLine( "", "Tanglish version is not available"));
            default:
                return List.of(new SongLine("", "Invalid language"));
        }
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
