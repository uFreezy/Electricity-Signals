package com.electricity.service;

import com.electricity.data.repositories.SignalRepository;
import com.electricity.model.Signal;
import com.electricity.model.User;
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
    public List<Signal> findByOwner(User user) {
        return this.signalRepository.findByOwner(user);
    }
}
