package com.company.bd.model.entities;

public class SchoolSubject {
    private final int schoolSubjectId;
    private final String name;

    public SchoolSubject(int schoolSubjectId, String name) {
        this.schoolSubjectId = schoolSubjectId;
        this.name = name;
    }

    public int getSchoolSubjectId() {
        return schoolSubjectId;
    }

    public String getName() {
        return name;
    }
}
