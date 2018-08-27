package com.example.constant;

import java.util.stream.Stream;

/**
 * Created by duguangquan on 2018/8/16.
 */
public enum SkinLevelEnum {


    HSS_LEVEL1("1", "低", 0, 29),

    HSS_LEVEL2("2", "中", 30, 49),

    HSS_LEVEL3("3", "高", 50, Integer.MAX_VALUE)

    ;

    private String code;

    private String name;

    private int minScore;

    private int maxScore;

    SkinLevelEnum(String code, String name, int minScore, int maxScore) {
        this.code = code;
        this.name = name;
        this.minScore = minScore;
        this.maxScore = maxScore;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getMinScore() {
        return minScore;
    }

    public int getMaxScore() {
        return maxScore;
    }



    public static SkinLevelEnum getByScore(int score) {

        return Stream.of(SkinLevelEnum.values())
                .filter(p -> p.minScore <= score && p.maxScore >= score)
                .findFirst()
                .orElse(null);
    }
}
