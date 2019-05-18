package com.electricity.dto;

public class DirectorSignalDto {

    private String address;

    private String description;

    private int timeForCompletion;

    public DirectorSignalDto(String address, String description, int timeForCompletion) {
        this.address = address;
        this.description = description;
        this.timeForCompletion = timeForCompletion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimeForCompletion() {
        return timeForCompletion;
    }

    public void setTimeForCompletion(int timeForCompletion) {
        this.timeForCompletion = timeForCompletion;
    }
}
