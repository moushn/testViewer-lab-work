package com.company.bd.model;

import com.company.bd.model.entities.SchoolSubject;
import com.company.bd.model.entities.TestEd;
import com.company.bd.model.entities.TestEdResults;

public class TestEdResultsPresent extends TestEdPresent {
    private final TestEdResults testEdResults;

    public TestEdResultsPresent(TestEd testEd, SchoolSubject schoolSubject, TestEdResults testEdResults) {
        super(testEd, schoolSubject);
        this.testEdResults = testEdResults;
    }

    public TestEdResults getTestEdResults() {
        return testEdResults;
    }
}
