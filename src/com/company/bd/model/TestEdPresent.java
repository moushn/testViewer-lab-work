package com.company.bd.model;

import com.company.bd.model.entities.SchoolSubject;
import com.company.bd.model.entities.TestEd;

public class TestEdPresent {
    private final TestEd testEd;
    private final SchoolSubject schoolSubject;

    public TestEdPresent(TestEd testEd, SchoolSubject schoolSubject) {
        this.testEd = testEd;
        this.schoolSubject = schoolSubject;
    }

    public TestEd getTestEd() {
        return testEd;
    }

    public SchoolSubject getSchoolSubject() {
        return schoolSubject;
    }
}
