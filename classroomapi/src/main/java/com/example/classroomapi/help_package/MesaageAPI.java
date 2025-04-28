package com.example.classroomapi.help_package;

public enum MesaageAPI {
    ERROR_DOCENT_NOT_FOUNT("Docent not found"),
    ERROR_STUDENT_NOT_FOUNT("Student not found"),
    ERROR_ASSISTANCE_NOT_FUND("ASsistance not found"),
    ERROR_COURSE_NOT_FUND("Course not found"),
    ERROR_QUALIFICATIONS_NOT_FUND("Qualifications not found"),
    ERROR_REGISTRATION_NOT_FUND("Registration not found"),
    ERROR_SUBJECT_NOT_FOUND("Subject not found"),
    ERROR_USER_NOT_FOUND("User not found")

    ;
// mensajes
    private String message;

    MesaageAPI(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
