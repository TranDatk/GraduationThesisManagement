package com.nhom39.service.implement;

import com.nhom39.pojo.Score;
import com.nhom39.repository.ScoreRepository;
import com.nhom39.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImplement implements ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public Score getScoreWithThesisIdAndCouncilDetailId(int thesisId, int councilDetailId) {
        return this.scoreRepository.getScoreWithThesisIdAndCouncilDetailId(thesisId, councilDetailId);
    }

    @Override
    public boolean addScore(Score score) {
        return this.scoreRepository.addScore(score);
    }

    @Override
    public boolean updateScore(int scoreId, Score score) {
        return this.scoreRepository.updateScore(scoreId, score);
    }
}
