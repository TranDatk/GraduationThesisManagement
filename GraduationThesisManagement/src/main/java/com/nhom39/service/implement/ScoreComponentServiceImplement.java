package com.nhom39.service.implement;

import com.nhom39.pojo.ScoreComponent;
import com.nhom39.repository.ScoreComponentRepository;
import com.nhom39.service.ScoreComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreComponentServiceImplement implements ScoreComponentService {
    @Autowired
    private ScoreComponentRepository scoreComponentRepository;

    @Override
    public List<ScoreComponent> getScoreComponents() {
        return this.scoreComponentRepository.getScoreComponents();
    }
}
