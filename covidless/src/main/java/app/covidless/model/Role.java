package app.covidless.model;

public enum Role {
    ADMIN,
    USER,
    DOCTOR;

    public String getAuthority(){ return name(); }
}
