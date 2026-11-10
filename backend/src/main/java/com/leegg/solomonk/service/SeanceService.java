package com.leegg.solomonk.service;

import com.leegg.solomonk.dto.CreerSeanceRequestDto;
import com.leegg.solomonk.dto.SeanceDto;
import com.leegg.solomonk.dto.SerieDto;
import com.leegg.solomonk.dto.SerieRequestDto;
import com.leegg.solomonk.entity.Exercice;
import com.leegg.solomonk.entity.Seance;
import com.leegg.solomonk.entity.SeanceType;
import com.leegg.solomonk.entity.Serie;
import com.leegg.solomonk.repository.ExerciceRepository;
import com.leegg.solomonk.repository.SeanceRepository;
import com.leegg.solomonk.repository.SeanceTypeRepository;
import com.leegg.solomonk.repository.SerieRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeanceService {

    private final SeanceRepository seanceRepository;
    private final SerieRepository serieRepository;
    private final SeanceTypeRepository seanceTypeRepository;
    private final ExerciceRepository exerciceRepository;

    public SeanceService(SeanceRepository seanceRepository,
                         SerieRepository serieRepository,
                         SeanceTypeRepository seanceTypeRepository,
                         ExerciceRepository exerciceRepository) {
        this.seanceRepository = seanceRepository;
        this.serieRepository = serieRepository;
        this.seanceTypeRepository = seanceTypeRepository;
        this.exerciceRepository = exerciceRepository;
    }

    @Transactional
    public SeanceDto creer(CreerSeanceRequestDto request) {
        SeanceType seanceType = seanceTypeRepository.findById(request.seanceTypeId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Séance type introuvable"));

        Seance seance = new Seance();
        seance.setDate(request.date());
        seance.setSeanceType(seanceType);
        seance = seanceRepository.save(seance);

        List<SerieDto> seriesDto = new ArrayList<>();
        for (SerieRequestDto serieRequest : request.series()) {

            Exercice exercice = exerciceRepository.findById(serieRequest.exerciceId()).orElseThrow();

            Serie serie = new Serie();
            serie.setSeance(seance);
            serie.setExercice(exercice);
            serie.setNumero(serieRequest.numero());
            serie.setReps(serieRequest.reps());
            serie.setCharge(serieRequest.charge());
            serieRepository.save(serie);

            seriesDto.add(new SerieDto(serie.getExercice().getNom(),serie.getNumero(), serie.getReps(), serie.getCharge()));
        }

        return new SeanceDto(seance.getId(), seance.getDate(), seanceType.getNom(), seriesDto);
    }
}
