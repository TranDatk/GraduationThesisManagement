/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom39.repository;

import com.nhom39.pojo.EvaluationMethod;

import java.util.List;
import java.util.Map;

public interface EvaluationMethodRepository {
    public List<EvaluationMethod> getEvaluationMethods ();
    public long countEvaluationMethod(Map<String, String> params);
    public EvaluationMethod getEvaluationMethodById(int evaluationMethodId);
    public EvaluationMethod getEvaluationMethodActive();
    public boolean addEvaluationMethod(EvaluationMethod evaluationMethod);
    public boolean updateEvaluationMethod(int evaluationMethodId, EvaluationMethod evaluationMethod);
    public boolean deleteEvaluationMethod(int evaluationMethodId);
    public boolean activeAEvaluationMethod(int evaluationMethodId);
}
