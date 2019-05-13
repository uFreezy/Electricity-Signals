package com.electricity.data.repositories;

import com.electricity.model.Signal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignalRepository extends JpaRepository<Signal, Long> {
    List<Signal> findByOwnerUsername(String username);

    List<Signal> findByIsCompleted(boolean isCompleted);

}
