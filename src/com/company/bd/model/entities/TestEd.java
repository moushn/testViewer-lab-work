package com.company.bd.model.entities;

public class TestEd {
    private final int testEdId;
    private final int schoolSubjectId;
    private final String name;

    public TestEd(int testEdId, int schoolSubjectId, String name) {
        this.testEdId = testEdId;
        this.schoolSubjectId = schoolSubjectId;
        this.name = name;
    }

    public int getTestEdId() {
        return testEdId;
    }

    public int getSchoolSubjectId() {
        return schoolSubjectId;
    }

    public String getName() {
        return name;
    }

    public int getQuestionsCount() {
        return (int) (Math.random() * 6) + 10;
    }
}
