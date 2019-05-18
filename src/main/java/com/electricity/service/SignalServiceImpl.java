package com.electricity.service;

import com.electricity.data.repositories.SignalRepository;
import com.electricity.model.Signal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalServiceImpl implements SignalService {
    private final SignalRepository signalRepository;

    public SignalServiceImpl(SignalRepository signalRepository) {
        this.signalRepository = signalRepository;
    }

    @Override
    public void save(Signal signal) {
        this.signalRepository.save(signal);
    }

    @Override
    public Signal findById(Long id) {
        return this.signalRepository.findById(id).orElse(null);
    }

    @Override
    public List<Signal> findByOwnerUsername(String username) {
        return this.signalRepository.findByOwnerUsername(username);
    }

    @Override
    public List<Signal> findAllUnresolved() {
        return this.signalRepository.findByIsCompleted(false);
    }

    @Override
    public List<Signal> findAllResolved() {
        return this.signalRepository.findByIsCompleted(true);
    }


    public boolean any() {
        return this.signalRepository.count() > 0;
    }

    @Override
    public long count() {
        return this.signalRepository.count();
    }
}
