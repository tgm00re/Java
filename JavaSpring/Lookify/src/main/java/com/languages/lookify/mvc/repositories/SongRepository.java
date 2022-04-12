package com.languages.lookify.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.languages.lookify.mvc.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();
	
	List<Song> findByArtistContaining(String search);
	
	List<Song> findTop10ByOrderByRatingDesc();
}
