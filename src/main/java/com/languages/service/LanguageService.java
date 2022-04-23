package com.languages.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.languages.models.Language;
import com.languages.repositories.LanguageRepository;



@Service
public class LanguageService {
	
	
	
	@Autowired 
	private LanguageRepository langRepo;
	
	public List<Language> all() {
		return langRepo.findAll();
	}
	
	public Language create(Language language) {
		return langRepo.save(language);
	}
	
	public Language find(Long id) {
		Optional<Language> optionalLanguage = langRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}else {
			return null;
		}
	}
		
	
	public void delete(Long id) {
		this.langRepo.deleteById(id);
	}
	
	public Language update(Language language) {
		return langRepo.save(language);
	}
	
	public Language retrieve(Long id) {
 		return this.langRepo.findById(id).get();
	}
	
	
	
	
	
	
	
	

		
		
	

}
