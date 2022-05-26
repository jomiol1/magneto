package com.magneto.service.implement;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magneto.util.ComparatorUtils;

import com.magneto.dto.StatsResponse;
import com.magneto.entity.DnaEntity;
import com.magneto.repository.DnaRepository;
import com.magneto.service.MutantService;

@Service
public class MutantServiceImplement implements MutantService{
	
	@Autowired
	private DnaRepository dnaRepository;
	
	@Override
	public boolean validate(String[] dna) {
		String dnaString = Arrays.toString(dna);
		Boolean check;
		
		Optional<DnaEntity> dnaOpt = dnaRepository.findByDna(dnaString);
		
		if(dnaOpt.isPresent()) 
			return dnaOpt.get().getMutant();

		check = this.check(dna);
		this.saveDna(dnaString, check);
		
		return check;
	}

	@Override
	public boolean check(String[] dna) {
		int mutantDna = 0;

		for (int i = 0; i < dna.length; i++) {
			for (int j = 0; j < dna[i].length(); j++) {

				if (j < dna[i].length() - 3) {
					if (ComparatorUtils.areEqualDna(dna[i].charAt(j), dna[i].charAt(j + 1), dna[i].charAt(j + 2),
							dna[i].charAt(j + 3))) {
						mutantDna++;
					}
				}

				if (i < dna[i].length() - 3) {
					if (ComparatorUtils.areEqualDna(dna[i].charAt(j), dna[i + 1].charAt(j), dna[i + 2].charAt(j),
							dna[i + 3].charAt(j))) {
						mutantDna++;
					}
				}

				if (j < dna[i].length() - 3 && i < dna[i].length() - 3) {
					if (ComparatorUtils.areEqualDna(dna[i].charAt(j), dna[i + 1].charAt(j + 1),
							dna[i + 2].charAt(j + 2), dna[i + 3].charAt(j + 3))) {
						mutantDna++;
					}
				}

				if (dna[i].length() > 3 && j < dna[i].length() - 3 && i > 2) {
					if (ComparatorUtils.areEqualDna(dna[i].charAt(j), dna[i - 1].charAt(j + 1),
							dna[i - 2].charAt(j + 2), dna[i - 3].charAt(j + 3))) {
						mutantDna++;
					}
				}

				if (mutantDna >= 2) {
					
					return Boolean.TRUE;
				}
			}

		}


		return Boolean.FALSE;
	}
	

	@Override
	public StatsResponse stats() {
		Long mutant = dnaRepository.countMutantOrPerson(Boolean.TRUE);
		Long person = dnaRepository.countMutantOrPerson(Boolean.FALSE);
		double ratio;
		
		if(mutant == 0 || person == 0) {
			ratio = 0.0;
		}else {
			ratio = mutant.doubleValue() / person.doubleValue();
		}
		
		
		return new StatsResponse(mutant,person,ratio);
	}
	
	void saveDna(String dna, Boolean check){
		DnaEntity dnaEntity = new DnaEntity();
		dnaEntity.setDna(dna);
		dnaEntity.setMutant(check);
		dnaEntity.setPerson(!check);
		
		dnaRepository.save(dnaEntity);
		
	}



}
