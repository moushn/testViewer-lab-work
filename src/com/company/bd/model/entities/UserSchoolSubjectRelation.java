package com.company.bd.model.entities;

public class UserSchoolSubjectRelation {
    private final int userId;
    private final int schoolSubjectId;

    public UserSchoolSubjectRelation(int userId, int schoolSubjectId) {
        this.userId = userId;
        this.schoolSubjectId = schoolSubjectId;
    }

    public int getUserId() {
        return userId;
    }

    public int getSchoolSubjectId() {
        return schoolSubjectId;
    }
}
