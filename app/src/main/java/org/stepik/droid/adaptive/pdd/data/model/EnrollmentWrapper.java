package org.stepik.droid.adaptive.pdd.data.model;

public class EnrollmentWrapper {
    private Enrollment enrollment;

    public EnrollmentWrapper(long courseId) {
        enrollment = new Enrollment(courseId);
    }
}