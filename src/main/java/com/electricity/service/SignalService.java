package com.electricity.service;

import com.electricity.model.Signal;

import java.util.List;

public interface SignalService {
    void save(Signal signal);

    Signal findById(Long id);

    List<Signal> findByOwnerUsername(String username);

    List<Signal> findAllUnresolved();

    boolean any();
}
