package com.leegg.solomonk.service;

import com.leegg.solomonk.dto.ExercicePrevuDto;
import com.leegg.solomonk.dto.SeanceTypeDto;
import com.leegg.solomonk.entity.ExercicePrevu;
import com.leegg.solomonk.entity.SeanceType;
import com.leegg.solomonk.repository.ExercicePrevuRepository;
import com.leegg.solomonk.repository.SeanceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeanceTypeService {
    private final SeanceTypeRepository seanceTypeRepository;
    private final ExercicePrevuRepository exercicePrevuRepository;

    public SeanceTypeService(SeanceTypeRepository seanceTypeRepository, ExercicePrevuRepository exercicePrevuRepository){
        this.seanceTypeRepository = seanceTypeRepository;
        this.exercicePrevuRepository = exercicePrevuRepository;
    }

    public List<SeanceTypeDto> findAll(){
        List<SeanceTypeDto> resultat = new ArrayList<>();

        for(SeanceType seanceType : seanceTypeRepository.findAll()){
            resultat.add(new SeanceTypeDto(seanceType.getId(), seanceType.getNom()));
        }
        return resultat;
    }
    public List<ExercicePrevuDto> findExercicesPrevus(Long seanceTypeId){
        List<ExercicePrevuDto> resultat = new ArrayList<>();
        for(ExercicePrevu exercicePrevu : exercicePrevuRepository.findBySeanceTypeIdOrderByOrdre(seanceTypeId)){
            resultat.add(new ExercicePrevuDto(exercicePrevu.getExercice().getId(),
                    exercicePrevu.getExercice().getNom(),
                    exercicePrevu.getOrdre(),
                    exercicePrevu.getSeriesCible(),
                    exercicePrevu.getRepsCible(),
                    exercicePrevu.getChargeCible()
            ));
        }
        return resultat;
    }
}
