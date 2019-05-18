package com.electricity.dto;

import java.util.List;

public class DirectorSignalGroupDto {

    private int solvedSignalsCount;

    private List<DirectorSignalDto> signalInfo;

    private List<DirectorServicemanDto> servicemanInfo;

    public DirectorSignalGroupDto(int solvedSignalsCount, List<DirectorSignalDto> signalInfo, List<DirectorServicemanDto> servicemanInfo) {
        this.solvedSignalsCount = solvedSignalsCount;
        this.signalInfo = signalInfo;
        this.servicemanInfo = servicemanInfo;
    }

    public int getSolvedSignalsCount() {
        return solvedSignalsCount;
    }

    public void setSolvedSignalsCount(int solvedSignalsCount) {
        this.solvedSignalsCount = solvedSignalsCount;
    }

    public List<DirectorSignalDto> getSignalInfo() {
        return signalInfo;
    }

    public void setSignalInfo(List<DirectorSignalDto> signalInfo) {
        this.signalInfo = signalInfo;
    }

    public List<DirectorServicemanDto> getServicemanInfo() {
        return servicemanInfo;
    }

    public void setServicemanInfo(List<DirectorServicemanDto> servicemanInfo) {
        this.servicemanInfo = servicemanInfo;
    }
}
