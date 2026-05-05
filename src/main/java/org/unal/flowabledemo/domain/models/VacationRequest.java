package org.unal.flowabledemo.domain.models;

public class VacationRequest {
    private String id;
    private String employee;
    private int days;
    private String status;

    public VacationRequest(String id, String employee, int days, String status) {
        this.id = id;
        this.employee = employee;
        this.days = days;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
