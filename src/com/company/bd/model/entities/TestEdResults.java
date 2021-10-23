package com.company.bd.model.entities;

public class TestEdResults {
    private final int testEdId;
    private final double averageScore;

    public TestEdResults(int testEdId, double averageScore) {
        this.testEdId = testEdId;
        this.averageScore = averageScore;
    }

    public int getTestEdId() {
        return testEdId;
    }

    public double getAverageScore() {
        return averageScore;
    }
}
