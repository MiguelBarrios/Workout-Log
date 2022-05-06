package com.skilldistillery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skilldistillery.entities.ExerciseSet;
import com.skilldistillery.repositories.ExerciseSetRepository;

@Service
public class ExerciseSetServiceImpl implements ExerciseSetService {

	@Autowired
	private ExerciseSetRepository exerciseRepo;
	
	@Override
	public ExerciseSet findById(int id) {
		Optional<ExerciseSet> option = exerciseRepo.findById(id);
		return (option.isPresent()) ? option.get() : null;
	}
	
	@Override
	public List<ExerciseSet> index(){
		return exerciseRepo.findAll();
	}
	
	@Override 
	public List<ExerciseSet> findByExerciseName(String name){
		return exerciseRepo.findByExerciseName(name);
	}
	
	@Override
	public ExerciseSet addSet(ExerciseSet set) {
		return exerciseRepo.saveAndFlush(set);
	}
	
}