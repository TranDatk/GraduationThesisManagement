package com.nhom39.repository;

import java.util.List;

public interface StatsRepository {
    public List<Object[]> thesisStatisticsByMajor(Integer schoolYearId);
    public List<Object[]> thesisScoreStatistics(Integer schoolYearId);
}
