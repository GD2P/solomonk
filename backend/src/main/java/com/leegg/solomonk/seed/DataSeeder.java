package com.leegg.solomonk.seed;

import com.leegg.solomonk.entity.Exercice;
import com.leegg.solomonk.entity.SeanceType;
import com.leegg.solomonk.entity.ExercicePrevu;
import com.leegg.solomonk.repository.ExercicePrevuRepository;
import com.leegg.solomonk.repository.ExerciceRepository;
import com.leegg.solomonk.repository.SeanceTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Charge le programme d'entraînement en base au démarrage, uniquement si la base est vide.
 * Outil de développement : à remplacer par des migrations (Flyway) en Sprint 2.
 */

@Component
public class DataSeeder implements CommandLineRunner {

    private final ExerciceRepository exerciceRepository;
    private final SeanceTypeRepository seanceTypeRepository;
    private final ExercicePrevuRepository exercicePrevuRepository;

    public DataSeeder(ExerciceRepository exerciceRepository,
                      SeanceTypeRepository seanceTypeRepository,
                      ExercicePrevuRepository exercicePrevuRepository) {
        this.exerciceRepository = exerciceRepository;
        this.seanceTypeRepository = seanceTypeRepository;
        this.exercicePrevuRepository = exercicePrevuRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (seanceTypeRepository.count() > 0) {
            return;
        }

        SeanceType pull1 = creerSeanceType("Pull #1");
        prevoir(pull1, creerExercice("Horizontal Pull"), 1, 4, 12, "52");
        prevoir(pull1, creerExercice("Curl pupitre"),    2, 4, 12, "25");
        prevoir(pull1, creerExercice("Lat pulldown"),    3, 4, 12, "45");
        prevoir(pull1, creerExercice("Hammer curl"),     4, 4, 10, "14");
        prevoir(pull1, creerExercice("Dumbbell curl"),   5, 3, 10, "12");
        prevoir(pull1, creerExercice("Seated row"),      6, 3, 10, "36");
    }

    private Exercice creerExercice(String nom) {
        Exercice exercice = new Exercice();
        exercice.setNom(nom);
        return exerciceRepository.save(exercice);
    }

    private SeanceType creerSeanceType(String nom) {
        SeanceType seanceType = new SeanceType();
        seanceType.setNom(nom);
        return seanceTypeRepository.save(seanceType);
    }

    private void prevoir(SeanceType seanceType, Exercice exercice,
                         int ordre, int series, int reps, String charge) {
        ExercicePrevu prevu = new ExercicePrevu();
        prevu.setSeanceType(seanceType);
        prevu.setExercice(exercice);
        prevu.setOrdre(ordre);
        prevu.setSeriesCible(series);
        prevu.setRepsCible(reps);
        prevu.setChargeCible(new BigDecimal(charge));
        exercicePrevuRepository.save(prevu);
    }
}
