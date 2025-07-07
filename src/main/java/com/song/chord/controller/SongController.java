package com.song.chord.controller;

import com.song.chord.model.Song;
import com.song.chord.model.SongLine;
import com.song.chord.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/songs")
@CrossOrigin(origins = "http://localhost:5173")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/lines")
    public Map<String, Object> getSongLinesById(@PathVariable Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);

        if (!optionalSong.isPresent()) {
            return Collections.singletonMap("error", "Song not found");
        }

        Song song = optionalSong.get();
        Map<String, Object> result = new HashMap<>();
        result.put("id", song.getId());
        result.put("title", song.getTitle());

        List<SongLine> linesTamil = song.getLinesTamil();
        List<SongLine> linesTanglish = song.getLinesTanglish();

        result.put("linesTamil", linesTamil.isEmpty()
                ? Collections.singletonList(new SongLine("", "தமிழ் பதிப்பு கிடைக்கவில்லை"))
                : linesTamil);

        result.put("linesTanglish", linesTanglish.isEmpty()
                ? Collections.singletonList(new SongLine("", "Tanglish version is not available"))
                : linesTanglish);

        return result;
    }

    @PostMapping
    public Song addSong(@RequestBody Song song) {
        return songRepository.save(song);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @RequestBody Song updatedSong) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if (optionalSong.isPresent()) {
            Song song = optionalSong.get();
            song.setTitle(updatedSong.getTitle());
            song.setLinesTamil(updatedSong.getLinesTamil());
            song.setLinesTanglish(updatedSong.getLinesTanglish());
            Song savedSong = songRepository.save(song);
            return ResponseEntity.ok(savedSong);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable Long id) {
        songRepository.deleteById(id);
    }

    @GetMapping("/search")
    public List<Song> searchSongsByTitle(@RequestParam String title) {
        return songRepository.findByTitleContainingIgnoreCase(title);
    }

    @GetMapping("/first5")
    public List<Song> getFirst5Songs() {
        Pageable firstFive = PageRequest.of(0, 5, Sort.by("title").ascending());
        return songRepository.findAllByOrderByTitleAsc(firstFive).getContent();
    }

    @GetMapping("/page")
    public List<Song> getSongsByPage(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("title").ascending());
        return songRepository.findAll(pageable).getContent();
    }
}
