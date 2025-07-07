package com.song.chord.controller;



import com.song.chord.dto.SongDTO;
import com.song.chord.impl.SongServiceImpl;
import com.song.chord.model.Song;
import com.song.chord.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend to call API
public class SongController {

    private final SongService songService;

    @Autowired
    private SongServiceImpl songServiceImpl;


    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/all")
    public List<Song> getAllSongsImpl() {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable Long id) {
        return songService.getSongById(id)
                .orElseThrow(() -> new RuntimeException("Song not found with ID: " + id));
    }

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return songService.saveSong(song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
    }



    @GetMapping
    public List<SongDTO> getAllSongs() {
        return songServiceImpl.getAllSongs();
    }

}

