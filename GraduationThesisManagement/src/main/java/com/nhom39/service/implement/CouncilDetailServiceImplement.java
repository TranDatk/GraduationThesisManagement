package com.nhom39.service.implement;

import com.nhom39.pojo.CouncilDetail;
import com.nhom39.pojo.Thesis;
import com.nhom39.repository.CouncilDetailRepository;
import com.nhom39.repository.ScoreRepository;
import com.nhom39.service.CouncilDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CouncilDetailServiceImplement implements CouncilDetailService {
    @Autowired
    private CouncilDetailRepository councilDetailRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public List<CouncilDetail> getCouncilsDetail(Map<String, String> params) {
        return this.councilDetailRepository.getCouncilsDetail(params);
    }

    @Override
    public List<Object[]> getCouncilsDetail(int lecturerId, Map<String, String> params) {
        return this.councilDetailRepository.getCouncilsDetail(lecturerId, params);
    }

    @Override
    public long countCouncilDetail(int lecturerId, Map<String, String> params) {
        return this.councilDetailRepository.countCouncilDetail(lecturerId, params);
    }

    @Override
    public CouncilDetail getCouncilDetailById(int councilDetailId) {
        CouncilDetail councilDetail = this.councilDetailRepository.getCouncilDetailById(councilDetailId);

        for (Thesis thesis : councilDetail.getCouncil().getTheses()) {
            thesis.setScored(this.scoreRepository.checkTheGradedThesisByCouncilDetailId(thesis.getId(), councilDetailId) > 0);
        }

        return councilDetail;
    }

    @Override
    public Boolean checkAllowAddAndEdit(int councilDetailId) {
        return this.councilDetailRepository.checkAllowAddAndEdit(councilDetailId);
    }
}
