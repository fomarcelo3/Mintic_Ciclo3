package com.costume.service;

import com.costume.model.Score;
import com.costume.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;

import org.hibernate.boot.model.process.internal.ScanningCoordinator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Servicio entidad Score
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
 
    public List<Score> getAll(){
       return scoreRepository.getAll();
    }
    
    public Score save(Score score) {
        if (score.getIdScore() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> scoreUno = scoreRepository.getScore(score.getIdScore());
            if (scoreUno.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }

    public  Score update(Score score){
        if (score.getIdScore() != null){
            Optional<Score> score_bd = scoreRepository.getScore(score.getIdScore());
            if (!score_bd.isEmpty()){
                if (score.getMessageText() != null){
                    score_bd.get().setMessageText(score.getMessageText());
                }

                if (score.getStars() != null && score.getStars() >= 0 && score.getStars() <= 5){
                    score_bd.get().setStars(score.getStars());
                }

                return  score_bd.get();
            }
        }

        return  score;
    }
    public boolean deleteScore(int id){
        Optional<Score> score  = scoreRepository.getScore(id);
        if (score.isEmpty()){
            return  false;
        }else {
            scoreRepository.delete(score.get());
            return  true;
        }
    }
}
