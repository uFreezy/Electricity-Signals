package com.electricity.service;

import com.electricity.model.Signal;
import com.electricity.model.User;

import java.util.List;

public interface SignalService {
    void save(Signal signal);

    List<Signal> findByOwner(User user);
}
