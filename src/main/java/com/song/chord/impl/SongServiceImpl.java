package com.song.chord.impl;

import com.song.chord.dto.SongDTO;
import com.song.chord.dto.SongLineDTO;
import com.song.chord.model.Song;
import com.song.chord.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl {

    @Autowired
    private SongRepository songRepository;

    public List<SongDTO> getAllSongs() {
        return songRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    private SongDTO convertToDTO(Song song) {
        SongDTO dto = new SongDTO();
        dto.setId(song.getId());
        dto.setTitle(song.getTitle());

        dto.setLinesTamil(song.getLinesTamil().stream().map(line -> {
            SongLineDTO lineDTO = new SongLineDTO();
            lineDTO.setChordLine(line.getChordLine());
            lineDTO.setLyricLine(line.getLyricLine());
            return lineDTO;
        }).toList());

        dto.setLinesTanglish(song.getLinesTanglish().stream().map(line -> {
            SongLineDTO lineDTO = new SongLineDTO();
            lineDTO.setChordLine(line.getChordLine());
            lineDTO.setLyricLine(line.getLyricLine());
            return lineDTO;
        }).toList());

        return dto;
    }
}

