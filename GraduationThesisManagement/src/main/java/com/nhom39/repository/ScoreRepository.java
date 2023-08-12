package com.nhom39.repository;

import com.nhom39.pojo.Score;

public interface ScoreRepository {
    public Score getScoreWithThesisIdAndCouncilDetailId(int thesisId, int councilDetailId);
    public long checkTheGradedThesisByCouncilDetailId(int thesisId, int councilDetailId);
    public boolean addScore(Score score);
    public boolean updateScore(int scoreId, Score score);
}
