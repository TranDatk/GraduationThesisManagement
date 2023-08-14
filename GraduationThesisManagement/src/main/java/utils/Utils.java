package utils;

import com.nhom39.constants.SystemConstant;
import com.nhom39.pojo.EvaluationMethod;
import com.nhom39.pojo.ScoreComponent;
import com.nhom39.pojo.ScoreColumn;

public class Utils {

    public static boolean checkTotalWeight(EvaluationMethod evaluationMethod) {
        double totalWeight = 0;

        for (ScoreComponent scoreComponent : evaluationMethod.getScoreComponents()) {
            for (ScoreColumn scoreColumn : scoreComponent.getScoreColumns()) {
                totalWeight += scoreColumn.getWeight();
            }
        }

        return totalWeight == 1;
    }

    public static int checkThesisResult(double score) {
        if (score >= SystemConstant.SCORE_PASS) {
            return 3;
        } else {
            return 2;
        }
    }

}
