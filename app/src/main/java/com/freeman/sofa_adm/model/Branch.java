package com.freeman.sofa_adm.model;

public class Branch extends BaseEntity {

    private String placeId;
    private Double latitude;
    private Double longitude;
    private String phoneNumber;
    private String openHours;
    private Department department;

    public Branch() {
    }

    public Branch(String placeId, Double latitude, Double longitude, String phoneNumber, String openHours) {
        this.placeId = placeId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phoneNumber = phoneNumber;
        this.openHours = openHours;
    }

    public Branch(String placeId, String phoneNumber) {
        this.placeId = placeId;
        this.phoneNumber = phoneNumber;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
