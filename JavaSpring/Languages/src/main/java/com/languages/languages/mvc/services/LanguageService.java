package com.languages.languages.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.languages.languages.mvc.models.Language;
import com.languages.languages.mvc.repositories.LanguageRepository;

@Service
public class LanguageService {
	LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	public Language create(Language language) {
		return languageRepo.save(language);
	}
	
	public List<Language> findAll(){
		return languageRepo.findAll();
	}
	
	public Language findOneById(Long id){
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	
	public Language update(Long id, String name, String creator, String version) {
		Language languageToUpdate = this.findOneById(id);
		if(languageToUpdate == null) {
			return null;
		}
		languageToUpdate.setName(name);
		languageToUpdate.setCreator(creator);
		languageToUpdate.setVersion(version);
		return languageRepo.save(languageToUpdate);
	}
	
	public void delete(Long id) {
		languageRepo.deleteById(id);
		
	}
	
	
	

}
