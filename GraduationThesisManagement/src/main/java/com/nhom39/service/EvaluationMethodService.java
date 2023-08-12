package com.nhom39.service;

import com.nhom39.pojo.EvaluationMethod;

import java.util.List;
import java.util.Map;

public interface EvaluationMethodService {
    public List<EvaluationMethod> getEvaluationMethods();
    public long countEvaluationMethod(Map<String, String> params);
    public boolean addEvaluationMethod(EvaluationMethod evaluationMethod);
    public EvaluationMethod getEvaluationMethodById(int evaluationMethodId);
    public EvaluationMethod getEvaluationMethodActive();
    public boolean updateEvaluationMethod(int evaluationMethodId, EvaluationMethod evaluationMethod);
    public boolean deleteEvaluationMethod(int evaluationMethodId);
    public boolean activeAEvaluationMethod(int evaluationMethodId);
}
