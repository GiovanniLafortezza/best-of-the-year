package org.lessons.java.bestoftheyear.controller;

import org.lessons.java.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class BestOfTheYearController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("year",2023);
        model.addAttribute("name", "Vanny");
        return "home";
    }

    @GetMapping("/songs")
    public String songsList(Model model) {
        List<Song> songs = getSongs();
        model.addAttribute("songs",songs);
        return "songs";
    }

    @GetMapping("/songs/details/{songId}")
    public String songsDetails(@PathVariable int songId, Model model) {
        Song song = getSongById(songId);
        model.addAttribute("song", song);
        return "song-details";
    }

    //metodo che restituisce una lista di canzoni
    private List<Song> getSongs() {
        List<Song> songs = new ArrayList<>();

        songs.add(new Song(1,"Not Afraid","Eminem"));
        songs.add(new Song(2,"ROCKSTAR","DaBaby"));
        songs.add(new Song(3,"Through Da Storm","Polo G"));

        return songs;

    }

    private Song getSongById(int id) {
        Song song = null;
        for (Song s : getSongs()) {
            if (s.getId() == id) {
                song = s;
                break;
            }
        }
        return song;
    }


}


