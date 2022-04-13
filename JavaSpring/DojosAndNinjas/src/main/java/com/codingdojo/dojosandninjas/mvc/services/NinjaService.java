package com.codingdojo.dojosandninjas.mvc.services;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.mvc.models.Ninja;
import com.codingdojo.dojosandninjas.mvc.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
}
