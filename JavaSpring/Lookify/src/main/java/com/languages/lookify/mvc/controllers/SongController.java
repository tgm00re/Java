package com.languages.lookify.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.languages.lookify.mvc.models.Song;
import com.languages.lookify.mvc.services.SongService;

@Controller 
public class SongController {
	private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songList = songService.findAll();
		model.addAttribute(songList);
		System.out.println("Song List: " + songList);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/songs/create")
	public String createSong(@ModelAttribute("song") Song song) {
		return "create.jsp";
	}
	
	@PostMapping("/process/create")
	public String processCreate(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		System.out.println("Processing Creation");
		if(result.hasErrors()) {
			return "redirect:/songs/create";
		} else {
			songService.create(song);
			return "redirect:/dashboard";
		}
		
	}
	
	@RequestMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteById(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/songs/view/{id}")
	public String displayOne(@PathVariable("id") Long id, Model model) {
		Song song = songService.findOneById(id);
		if(song == null) {
			return "redirect:/dashboard";
		}
		model.addAttribute(song);
		return "displayone.jsp";
	}
	
	
	@RequestMapping("/songs/search/{search}")
	public String search(@PathVariable("search") String search, Model model) {
		System.out.println("Printing path variable: " + search);
		List<Song> songList = songService.findByArtistContaining(search);
		System.out.println("under 78");
		model.addAttribute("songList", songList);
		model.addAttribute("name", search);
		return "search.jsp";
	}
	
	@PostMapping("/process/search")
	public String processSearch(@RequestParam(value="search") String search) {
		return "redirect:/songs/search/" + search;
	}
	
	@RequestMapping("/songs/topten")
	public String topTen(Model model) {
		List<Song> songList = songService.findTop10ByOrderByRatingDesc();
		model.addAttribute(songList);
		return "topten.jsp";
	}
	
	
	
	
	
}
