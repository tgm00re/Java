package com.languages.lookify.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.languages.lookify.mvc.models.Song;
import com.languages.lookify.mvc.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepo;
	
	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	
	//CREATE
	public Song create(Song song) {
		return songRepo.save(song);
	}
	
	
	//READ
	public List<Song> findAll() {
		return songRepo.findAll();
	}
	
	public Song findOneById(Long id) {
		Optional<Song> song = songRepo.findById(id);
		if(song.isPresent()) {
			return song.get();
		}
		return null;
	}
	
	
	
	public List<Song> findByArtistContaining(String search) {
		System.out.println(search.getClass().getName());
		System.out.println("hello!" + search);
		List<Song> songList = songRepo.findByArtistContaining(search);
		System.out.println(songList);
		return songList;
	}
	

	public List<Song> findTop10ByOrderByRatingDesc(){
		return songRepo.findTop10ByOrderByRatingDesc();
	}
	
	//UPDATE
	public Song update(Long id, String title, String artist, Integer rating) {
		Song songToUpdate = this.findOneById(id);
		if(songToUpdate == null) {
			return null;
		}
		songToUpdate.setTitle(title);
		songToUpdate.setArtist(artist);
		songToUpdate.setRating(rating);
		return songRepo.save(songToUpdate);
	}
	
	
	
	//DELETE
	public void deleteById(Long id) {
		songRepo.deleteById(id);
	}
}
