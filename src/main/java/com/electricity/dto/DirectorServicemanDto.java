package com.electricity.dto;

public class DirectorServicemanDto {

    private String username;

    private int signalsSolved;

    public DirectorServicemanDto(String username, int signalsSolved) {
        this.username = username;
        this.signalsSolved = signalsSolved;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSignalsSolved() {
        return signalsSolved;
    }

    public void setSignalsSolved(int signalsSolved) {
        this.signalsSolved = signalsSolved;
    }
}
